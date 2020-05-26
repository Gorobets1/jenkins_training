/***************
***************
JUST COPY AND PASTE FROM OLD SOLUTION
***************
***************/
def remoteBuildInvoke(mainUrl, jobUrl, jobParams, userCreds){
  def crumbUrl = """${mainUrl}/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)"""
  def crumbConn = crumbUrl.toURL().openConnection()
  crumbConn.setRequestProperty("Authorization", "Basic ${userCreds}")
  crumb = crumbConn.content.text
    
  jobUrl = "${mainUrl}${jobUrl}/${jobParams}"
  def jobConn = jobUrl.toURL().openConnection()
  jobConn.setRequestProperty("Authorization", "Basic ${userCreds}")
  jobConn.setRequestProperty("Header", "${crumb}")
  return jobConn.responseCode
}

def getNextBuildNumber(jobUrl, userCreds){
    jobUrl = "$jobUrl/api/json"
    def conn = jobUrl.toURL().openConnection()
    conn.setRequestProperty("Authorization", "Basic ${userCreds}")
    if (conn.responseCode == 200){
        def object = new groovy.json.JsonSlurper().parseText(conn.content.text)
        return object["nextBuildNumber"]
    }else{
        return "ERROR to get next build number for $jobUrl"
    }
}

def getJobStatus(jobUrl, buildNumber, userCreds){
    jobUrl="$jobUrl/$buildNumber/api/json"
    def conn = jobUrl.toURL().openConnection()
    conn.setRequestProperty("Authorization", "Basic ${userCreds}")
    // println "on 1st attempt ${conn.responseCode}"
    // if (conn.responseCode != 200){
    //     sleep 10
    //     conn = jobUrl.toURL().openConnection()
    //     println "on 2st attempt ${conn.responseCode}"
    // }
    
    // println conn.content.text
    if (conn.responseCode == 200){
        def object = new groovy.json.JsonSlurper().parseText(conn.content.text)
        return object["result"]
    }else{
        return "NOT RESPOND"
    }
}

def continiousJobStatusCheck(jobUrl, buildNumber, userCreds){
    def result = getJobStatus(jobUrl, buildNumber, userCreds)
    // results = ["FAILURE", "UNSTABLE", "SUCCESS", "ABORTED"]
    while (  result == null ){
        // println "current result is $result"
        // println new Date().format('yyyyMMddHH:mm:ss')
        sleep 60 // time in sec
        result = getJobStatus(jobUrl, buildNumber, userCreds)
    }
    return result
}


def generalTests(List componetsToTest, String env, Map testSuite, Boolean debug){

    def remoteJenkinsUserKey = [
        "http://:8080": "",
        "http://:8083": "",
        "http://:8080": "",
    ]

    env = env.toLowerCase();
    overallResult = "SUCCESS"
    failedTests = []
    //stageName = "Application testing "
    //notifyBuildWithSlack("STARTED", stageName)
    def instances = [:]
    for (int testNum = 0; testNum < componetsToTest.size(); testNum++) {
        def component = componetsToTest[testNum].toLowerCase()
        def sleepTime = testNum*5
        instances["$env-$component"] = {
            //stage("$component"){
            try{
                // notifyBuildWithSlack("STARTED", stageName+ ": Test-$env-$component: ")
                def jobParams = testSuite[component]["params"]
                def mainUrl = testSuite[component]["mainUrl"]
                def jobUrl = testSuite[component]["jobUrl"]
                def jobToken = testSuite[component]["jobToken"]
                def remoteCreds = remoteJenkinsUserKey[mainUrl]
                // sleep step here to workaround nextBuild number for multuple instances of same jobs
                sleep sleepTime
                def buildNumber = getNextBuildNumber(mainUrl+jobUrl, remoteCreds)
                if ( jobParams != null ){
                    jobParams = "buildWithParameters?delay=0sec&token=${jobToken}&${jobParams}"
                }else{
                    jobParams = "build?delay=0sec&token=${jobToken}"
                }
                print("""
                >>>>>Debug Remote Jenkins>>>>>
                    mainUrl=${mainUrl}
                    jobUrl=${jobUrl}
                    buildNumber=${buildNumber}
                    jobParams=${jobParams}
                    remoteCreds=${remoteCreds}
                """);
                if ( debug == false ) {
                    def newJob = remoteBuildInvoke(mainUrl, jobUrl, jobParams, remoteCreds)
                    sleep 10
                    if ( newJob == 201 ){
                        println "$mainUrl$jobUrl/$buildNumber has been started"
                        // notifyBuildWithSlack("STARTED", stageName+ ": $env-$component: $mainUrl$jobUrl/$buildNumber has been started")
                        def jobResult = continiousJobStatusCheck(mainUrl+jobUrl, buildNumber, remoteCreds)
                        println "$mainUrl$jobUrl/$buildNumber finished with status $jobResult"
                        // notifyBuildWithSlack("$jobResult", stageName+ ": Test-$env-$component: $mainUrl$jobUrl/$buildNumber ")
                        if ( jobResult != "SUCCESS" ){
                            overallResult = jobResult
                            failedTests.add(component)
                            // notifyBuildWithSlack(jobResult, stageName+ ": Test-$env-$component: job result check is required by QA team. Test job status is")
                        }
                    }
                    else{
                        println "$mainUrl$jobUrl cannot be started because of some reasons"
                        // notifyBuildWithSlack("FAILED", stageName+ ": Test-$env-$component: $mainUrl$jobUrl cannot be run")
                        overallResult = "FAILURE"
                        failedTests.add(component)
                    }
                }
            }catch(e){
                println e.getStackTrace().join('\n')
                overallResult = "FAILURE"
            }
            //} stage
        }
    }
    parallel instances
    //currentBuild.result = overallResult
    //notifyBuildWithSlack("FINISHED", "Application testing")
    return [overallResult, failedTests]
}

return this
