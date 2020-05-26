def realServerNames = [
   'datahq':[
        'beta':[
            'app_set_1':[
                'app_node_01':'CRDQN1VBDHQAP20',
                'svc_node_01':'CRDQN1VBDHQAP20'
            ],
            'app_set_2':[
                'app_node_02':'CRDQN1VBDHQAP21',
                'svc_node_02':'CRDQN1VBDHQAP21'
            ]
        ],
        'dr':[
            'app_set_1':[
                'app_node_01':'CRDPN1VRDHQAP21',
                'app_node_03':'CRDPN1VRDHQAP23',
                'app_node_05':'CRDPN1VRDHQAP25',
                'app_node_07':'CRDPN1VRDHQAP27',
                'svc_node_01':'CRDPN1VRSVCAP21'
            ],
            'app_set_2':[
                'app_node_02':'CRDPN1VRDHQAP22',
                'app_node_04':'CRDPN1VRDHQAP24',
                'app_node_06':'CRDPN1VRDHQAP26',
                'app_node_08':'CRDPN1VRDHQAP28',
                'svc_node_02':'CRDPN1VRSVCAP22'
            ]
        ],
        'prod':[
            'app_set_1':[
                'app_node_01':'CRDQN1VPDHQAP21',
                'app_node_03':'CRDQN1VPDHQAP23',
                'app_node_05':'CRDQN1VPDHQAP25',
                'app_node_07':'CRDQN1VPDHQAP27',
                'svc_node_01':'CRDQN1VPSVCAP20'
            ],
            'app_set_2':[
                'app_node_02':'CRDQN1VPDHQAP22',
                'app_node_04':'CRDQN1VPDHQAP24',
                'app_node_06':'CRDQN1VPDHQAP26',
                'app_node_08':'CRDQN1VPDHQAP28',
                'svc_node_02':'CRDQN1VPSVCAP21'
            ]
        ]
    ]
]

def testsSets = [
    'datahq':[
        'app':[],
        "app_set_1": [
            "app_node_01", 
            "app_node_03", 
            "app_node_05", 
            "app_node_07"
        ],
        "app_set_2": [
            "app_node_02", 
            "app_node_04", 
            "app_node_06", 
            "app_node_08"
        ],
        "prod": [
            "datahq", 
            "pfm", 
            "analytics", 
            "credcoconnect", 
            "red_tool", 
            "os_tools", 
            "customersupport_tool"
        ],
        "dr": [
            "datahq", 
            "pfm", 
            "credcoconnect"
        ],
        "beta": [
            "datahq", 
            "pfm", 
            "analytics", 
            "credcoconnect", 
            "red_tool", 
            "os_tools", 
            "customersupport_tool"
        ],
    ]
];

def testSuite = [ 
    'datahq': [
        "beta": [
            "datahq": [
                "mainUrl": "http://:",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Beta&Node=LB"
            ],
            "pfm": [
                "mainUrl": "http://",
                "jobUrl": "/job/PFM/job/PFM_BETA",
                "jobToken": "",
                "params": "ReportPortalProfile=RP"
            ],
            "analytics": [
                "mainUrl": "http://",
                "jobUrl": "/job/Analytics/job/Analytics_BETA",
                "jobToken": "",
                "params": null
            ],
            "credcoconnect": [
                "mainUrl": "http://",
                "jobUrl": "/job/CredcoConnect/job/test_automation/job/CredcoConnect_BETA",
                "jobToken": "",
                "params": null
            ],
            "customersupport_tool": [
                "mainUrl": "http://",
                "jobUrl": "/job/CustomerSupport_Tool/job/CustomerSupport_Tool_BETA",
                "jobToken": "",
                "params": ""
            ],
            "red_tool": [
                "mainUrl": "http://",
                "jobUrl": "/job/RED_Tool/job/RED_Tool_Beta",
                "jobToken": "",
                "params": null
            ],
            "os_tools": [
                "mainUrl": "http://",
                "jobUrl": "/job/OS_Tools/job/OS_Tools_Beta",
                "jobToken": "",
                "params": null
            ],
            "app_node_01": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Beta&Node=1"
            ],
            "app_node_02": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Beta&Node=2"
            ],
        ],
        "prod": [
            "datahq": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=LB"
            ],
            "pfm": [
                "mainUrl": "http://",
                "jobUrl": "/job/PFM/job/PFM_PROD",
                "jobToken": "",
                "params": "ReportPortalProfile=NORP"
            ],
            "analytics": [
                "mainUrl": "http://",
                "jobUrl": "/job/Analytics/job/Analytics_PROD",
                "jobToken": "",
                "params": null
            ],
            "credcoconnect": [
                "mainUrl": "http://"
                "jobUrl": "/job/CredcoConnect/job/test_automation/job/CredcoConnect_PROD",
                "jobToken": "",
                "params": null
            ],
            "customersupport_tool": [
                "mainUrl": "http://",
                "jobUrl": "/job/CustomerSupport_Tool/job/CustomerSupport_Tool_PROD",
                "jobToken": "",
                "params": ""
            ],
            "red_tool": [
                "mainUrl": "http://",
                "jobUrl": "/job/RED_Tool/job/RED_Tool_Prod",
                "jobToken": "",
                "params": null
            ],
            "os_tools": [
                "mainUrl": "http://",
                "jobUrl": "/job/OS_Tools/job/OS_Tools_Prod",
                "jobToken": "",
                "params": null
            ],
            "app_node_01": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=1"
            ],
            "app_node_02": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=2"
            ],
            "app_node_03": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=3"
            ],
            "app_node_04": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=4"
            ],
            "app_node_05": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=5"
            ],
            "app_node_06": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=6"
            ],
            "app_node_07": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=7"
            ],
            "app_node_08": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Prod&Node=8"
            ]
        ],
        "dr": [
            "pfm": [
                "mainUrl": "http://",
                "jobUrl": "/job/PFM/job/PFM_DR",
                "jobToken": "",
                "params": "ReportPortalProfile=NORP"
            ],
            "credcoconnect": [
                "mainUrl": "http://",
                "jobUrl": "/job/CredcoConnect/job/test_automation/job/CredcoConnect_DR",
                "jobToken": "",
                "params": null
            ],
            "datahq": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=LB"
            ],
            "app_node_01": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=1"
            ],
            "app_node_02": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=2"
            ],
            "app_node_03": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=3"
            ],
            "app_node_04": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=4"
            ],
            "app_node_05": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=5"
            ],
            "app_node_06": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=6"
            ],
            "app_node_07": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=7"
            ],
            "app_node_08": [
                "mainUrl": "http://",
                "jobUrl": "/job/DataHQ/job/QA/job/DATAHQ_UTAF_BETA_PROD",
                "jobToken": "",
                "params": "Env=Dbar&Node=8"
            ],
        ]
    ]
];

return [
        testsSets:testsSets,
        testSuite:testSuite
];
