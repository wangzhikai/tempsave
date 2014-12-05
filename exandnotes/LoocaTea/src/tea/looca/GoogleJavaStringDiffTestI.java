package tea.looca;

import java.util.LinkedList;
import java.util.List;

import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;

public class GoogleJavaStringDiffTestI {

	public static void main(String[] args) {
		  String text1 = "name/fraser/neil/plaintext/Speedtest1.txt";
	    String text2 = "name/fraser/neil/plaintext/Speedtest2.txt";

	    diff_match_patch dmp = new diff_match_patch();
	    dmp.Diff_Timeout = 0;

	    // Execute one reverse diff as a warmup.
	    List<Diff> ldiff = dmp.diff_main(text2, text1, false);
	    for (Diff d : ldiff) {
	    	System.out.println(d);
	    }
	    /*This snake has some feet, anyway it works
Diff(EQUAL,"name/fraser/neil/plaintext/Speedtest")
Diff(DELETE,"2")
Diff(INSERT,"1")
Diff(EQUAL,".txt")
	     */

	    ldiff = dmp.diff_main(diff1, diff2, false);
	    for (Diff d : ldiff) {
	    	System.out.println(d);
	    }
	    
	    
/* This is awsome!
Diff(EQUAL,"name/fraser/neil/plaintext/Speedtest")
Diff(DELETE,"2")
Diff(INSERT,"1")
Diff(EQUAL,".txt")
Diff(INSERT,"15:37:42 INFO  Utilities - Trigger in Json :¶")
Diff(EQUAL,"{¶    "failures": null,¶    "transactionIds": null,¶    "triggers": [¶        {¶            "id": "8c38266dc64c4cd98ae7cbc8795f2808",¶            "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶            "sequences": [¶                {¶                    "name": "switchviews",¶                    "actions": [¶                        {¶                            "id": "c83217979356489386bab77b1bed068e",¶                            "properties": {¶                                "duration": "1.0",¶                                "direction": "down",¶                                "transitionType": "TRANS_TYPE_DROP",¶                                "delay": "0.25"¶                            },¶                            "type": "switchviews",¶                            "targets": [¶                                "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide"¶                            ]¶                        },¶                        {¶                            "id": "aea0e983b3be44edba8d4c5f4351d863",¶                            "properties": {¶                                "duration": "1.0",¶                                "transitionType": "TRANS_TYPE_FADE",¶                                "delay": "0.5"¶                            },¶                            "type": "switchviews",¶                            "targets": [¶                                "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous"¶                            ]¶                        },¶                        {¶                            "id": "15c5b5e336aa401a8e1a3182e7d2d90d",¶                            "properties": {¶                                "duration": "1.0",¶                                "direction": "horizontal",¶                                "transitionType": "TRANS_TYPE_CLIP",¶                                "delay": "0.0"¶                            },¶                            "type": "switchviews",¶                            "targets": [¶                                "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next"¶                            ]¶                        }¶                    ]¶                },¶                {¶                    "name": "switchviews",¶                    "actions": [¶                        {¶                            "id": "6bd01e53dabf450aa9181f91e94d272a",¶                            "properties": {¶                                "transitionType": "TRANS_TYPE_NONE",¶                                "delay": "0.0"¶                            },¶                            "type": "switchviews",¶                            "targets": [¶                                "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous"¶                            ]¶                        }")
Diff(DELETE,",¶                        {¶                            "id": "691a89772e394cab8c6458743b948080",¶                            "properties": {¶                                "transitionType": "TRANS_TYPE_NONE",¶                                "delay": "0.0"¶                            },¶                            "type": "switchviews",¶                            "targets": [¶                                "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous"¶                            ]¶                        }")
Diff(EQUAL,"¶                    ]¶                }¶            ],¶            "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶            "properties": {¶                "name": "Pick an event 1"¶            },¶            "type": "onclick",¶            "sourceId": "19cfeb0a10b84fe1960305b965aae748"¶        }¶    ],¶    "type": null¶}¶15:3")
Diff(DELETE,"8")
Diff(INSERT,"7")
Diff(EQUAL,":")
Diff(DELETE,"58")
Diff(INSERT,"42")
Diff(EQUAL," INFO  Utilities - Chapter content :¶{¶    "content": {¶        "styleId": "e69df92a9fe84451bf1d6e752075b69a",¶        "id": "8d232a5ce8a54e87a2cf139be3025b46",¶        "widgets": [¶            {¶                "id": "19cfeb0a10b84fe1960305b965aae748",¶                "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                "containerKey": "8d232a5ce8a54e87a2cf139be3025b46",¶                "name": "Button 1",¶                "children": [¶                    ¶                ],¶                "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                "triggers": [¶                    {¶                        "id": "8c38266dc64c4cd98ae7cbc8795f2808",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "sequences": [¶                            {¶                                "name": "switchviews",¶                                "actions": [¶                                    {¶                                        "id": "c83217979356489386bab77b1bed068e",¶                                        "properties": {¶                                            "duration": "1.0",¶                                            "direction": "down",¶                                            "transitionType": "TRANS_TYPE_DROP",¶                                            "delay": "0.25"¶                                        },¶                                        "type": "switchviews",¶                                        "targets": [¶                                            "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide"¶                                        ]¶                                    },¶                                    {¶                                        "id": "aea0e983b3be44edba8d4c5f4351d863",¶                                        "properties": {¶                                            "duration": "1.0",¶                                            "transitionType": "TRANS_TYPE_FADE",¶                                            "delay": "0.5"¶                                        },¶                                        "type": "switchviews",¶                                        "targets": [¶                                            "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous"¶                                        ]¶                                    },¶                                    {¶                                        "id": "15c5b5e336aa401a8e1a3182e7d2d90d",¶                                        "properties": {¶                                            "duration": "1.0",¶                                            "direction": "horizontal",¶                                            "transitionType": "TRANS_TYPE_CLIP",¶                                            "delay": "0.0"¶                                        },¶                                        "type": "switchviews",¶                                        "targets": [¶                                            "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next"¶                                        ]¶                                    }¶                                ]¶                            },¶                            {¶                                "name": "switchviews",¶                                "actions": [¶                                    {¶                                        "id": "6bd01e53dabf450aa9181f91e94d272a",¶                                        "properties": {¶                                            "transitionType": "TRANS_TYPE_NONE",¶                                            "delay": "0.0"¶                                        },¶                                        "type": "switchviews",¶                                        "targets": [¶                                            "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65")
Diff(DELETE,":Previous"¶                                        ]¶                                    },¶                                    {¶                                        "id": "691a89772e394cab8c6458743b948080",¶                                        "properties": {¶                                            "transitionType": "TRANS_TYPE_NONE",¶                                            "delay": "0.0"¶                                        },¶                                        "type": "switchviews",¶                                        "targets": [¶                                            "/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e")
Diff(EQUAL,":Previous"¶                                        ]¶                                    }¶                                ]¶                            }¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "properties": {¶                            "name": "Pick an event 1"¶                        },¶                        "type": "onclick",¶                        "sourceId": "19cfeb0a10b84fe1960305b965aae748"¶                    }¶                ],¶                "properties": {¶                    "hidden": "false",¶                    "value": "Button",¶                    "locked": "false",¶                    "z": "0",¶                    "y": "78",¶                    "push": "false",¶                    "disabled": "false",¶                    "x": "286"¶                },¶                "type": "BUTTON"¶            },¶            {¶                "id": "48f4a4b07e394f678abb66843f550b65",¶                "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                "containerKey": "8d232a5ce8a54e87a2cf139be3025b46",¶                "name": "Dynamic Display 1",¶                "children": [¶                    {¶                        "id": "3a777c7daa054a569b9c6025d0f38cac",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "48f4a4b07e394f678abb66843f550b65",¶                        "name": "Section 1",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#8acf58",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "true",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "0",¶                            "y": "210",¶                            "draggable": "no",¶                            "x": "129"¶                        },¶                        "type": "SECTION"¶                    },¶                    {¶                        "id": "c59f59306b8341bbb2cfff4eea834ff7",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "48f4a4b07e394f678abb66843f550b65",¶                        "name": "Section 2",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#ffbc29",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "false",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "1",¶                            "y": "0",¶                            "draggable": "no",¶                            "x": "0"¶                        },¶                        "type": "SECTION"¶                    }¶                ],¶                "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                "triggers": [¶                    ¶                ],¶                "properties": {¶                    "locked": "false",¶                    "z": "1",¶                    "y": "210",¶                    "rules": "None",¶                    "x": "129"¶                },¶                "type": "CONDITIONAL_HTML"¶            },¶            {¶                "id": "bfb115b6523749e5a981efea54b21ba1",¶                "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                "containerKey": "8d232a5ce8a54e87a2cf139be3025b46",¶                "name": "Dynamic Display 3",¶                "children": [¶                    {¶                        "id": "7fea852b8edf4836b941170b82119001",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "bfb115b6523749e5a981efea54b21ba1",¶                        "name": "Section 1",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#a0a0a0",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "true",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "0",¶                            "y": "0",¶                            "draggable": "no",¶                            "x": "0"¶                        },¶                        "type": "SECTION"¶                    },¶                    {¶                        "id": "77c487ba8e454c6ba61c6e39df84ac03",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "bfb115b6523749e5a981efea54b21ba1",¶                        "name": "Section 2",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#ff0000",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "false",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "1",¶                            "y": "0",¶                            "draggable": "no",¶                            "x": "0"¶                        },¶                        "type": "SECTION"¶                    }¶                ],¶                "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                "triggers": [¶                    ¶                ],¶                "properties": {¶                    "locked": "false",¶                    "z": "2",¶                    "y": "218",¶                    "rules": "None",¶                    "x": "656"¶                },¶                "type": "CONDITIONAL_HTML"¶            },¶            {¶                "id": "48f79eb0d2644e12a5872ea075adc36e",¶                "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                "containerKey": "8d232a5ce8a54e87a2cf139be3025b46",¶                "name": "Dynamic Display 2",¶                "children": [¶                    {¶                        "id": "f976d78a11ac48f08509b9e37457e8ef",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "48f79eb0d2644e12a5872ea075adc36e",¶                        "name": "Section 1",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#00adef",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "true",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "0",¶                            "y": "0",¶                            "draggable": "no",¶                            "x": "0"¶                        },¶                        "type": "SECTION"¶                    },¶                    {¶                        "id": "a21fa9428df640e0a513727ac791bc21",¶                        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                        "containerKey": "48f79eb0d2644e12a5872ea075adc36e",¶                        "name": "Section 2",¶                        "children": [¶                            ¶                        ],¶                        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                        "triggers": [¶                            ¶                        ],¶                        "properties": {¶                            "clip": "No",¶                            "horizontalScroll": "Auto",¶                            "backgroundColor": "#b00000",¶                            "width": "200",¶                            "push": "false",¶                            "height": "150",¶                            "defaultBranchView": "false",¶                            "hidden": "false",¶                            "layout": "absolute",¶                            "verticalScroll": "Auto",¶                            "locked": "false",¶                            "z": "1",¶                            "y": "0",¶                            "draggable": "no",¶                            "x": "0"¶                        },¶                        "type": "SECTION"¶                    }¶                ],¶                "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                "triggers": [¶                    ¶                ],¶                "properties": {¶                    "locked": "false",¶                    "z": "3",¶                    "y": "219",¶                    "rules": "None",¶                    "x": "397"¶                },¶                "type": "CONDITIONAL_HTML"¶            },¶            {¶                "id": "9c7b5c53a737447da7f9179c361aabc8",¶                "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶                "containerKey": "8d232a5ce8a54e87a2cf139be3025b46",¶                "name": "Button 3",¶                "children": [¶                    ¶                ],¶                "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶                "triggers": [¶                    ¶                ],¶                "properties": {¶                    "hidden": "false",¶                    "value": "Button",¶                    "locked": "false",¶                    "z": "4",¶                    "y": "86",¶                    "push": "false",¶                    "disabled": "false",¶                    "x": "767"¶                },¶                "type": "BUTTON"¶            }¶        ],¶        "chapterId": "de3c3b8ef048490096bae88ad586ee41",¶        "name": "Case 1",¶        "projectId": "5499c004455a44ccba81f7feb5bde2a4",¶        "triggers": [¶            ¶        ],¶        "properties": {¶            "clip": "Horizontal",¶            "height": "600",¶            "horizontalScroll": "Auto",¶            "width": "1000",¶            "align": "Fit to window",¶            "verticalScroll": "Auto",¶            "media": "page"¶        },¶        "type": "PAGE"¶    }¶}")

 */
	    
	    System.out.println(dmp.diff_prettyHtml((LinkedList<Diff>) ldiff));
	}
	

    static final String diff1 = "{\n" +
            "    \"failures\": null,\n" +
            "    \"transactionIds\": null,\n" +
            "    \"triggers\": [\n" +
            "        {\n" +
            "            \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "            \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "            \"sequences\": [\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"down\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                \"delay\": \"0.25\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                \"delay\": \"0.5\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"horizontal\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"691a89772e394cab8c6458743b948080\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "            \"properties\": {\n" +
            "                \"name\": \"Pick an event 1\"\n" +
            "            },\n" +
            "            \"type\": \"onclick\",\n" +
            "            \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"type\": null\n" +
            "}\n" +
            "15:38:58 INFO  Utilities - Chapter content :\n" +
            "{\n" +
            "    \"content\": {\n" +
            "        \"styleId\": \"e69df92a9fe84451bf1d6e752075b69a\",\n" +
            "        \"id\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "        \"widgets\": [\n" +
            "            {\n" +
            "                \"id\": \"19cfeb0a10b84fe1960305b965aae748\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 1\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    {\n" +
            "                        \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"sequences\": [\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"down\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                            \"delay\": \"0.25\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                            \"delay\": \"0.5\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"horizontal\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"691a89772e394cab8c6458743b948080\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"properties\": {\n" +
            "                            \"name\": \"Pick an event 1\"\n" +
            "                        },\n" +
            "                        \"type\": \"onclick\",\n" +
            "                        \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"0\",\n" +
            "                    \"y\": \"78\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"286\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 1\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"3a777c7daa054a569b9c6025d0f38cac\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#8acf58\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"210\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"129\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"c59f59306b8341bbb2cfff4eea834ff7\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ffbc29\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"1\",\n" +
            "                    \"y\": \"210\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"129\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 3\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"7fea852b8edf4836b941170b82119001\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#a0a0a0\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"77c487ba8e454c6ba61c6e39df84ac03\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ff0000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"2\",\n" +
            "                    \"y\": \"218\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"656\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 2\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"f976d78a11ac48f08509b9e37457e8ef\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#00adef\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"a21fa9428df640e0a513727ac791bc21\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#b00000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"3\",\n" +
            "                    \"y\": \"219\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"397\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"9c7b5c53a737447da7f9179c361aabc8\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 3\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"4\",\n" +
            "                    \"y\": \"86\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"767\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "        \"name\": \"Case 1\",\n" +
            "        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "        \"triggers\": [\n" +
            "            \n" +
            "        ],\n" +
            "        \"properties\": {\n" +
            "            \"clip\": \"Horizontal\",\n" +
            "            \"height\": \"600\",\n" +
            "            \"horizontalScroll\": \"Auto\",\n" +
            "            \"width\": \"1000\",\n" +
            "            \"align\": \"Fit to window\",\n" +
            "            \"verticalScroll\": \"Auto\",\n" +
            "            \"media\": \"page\"\n" +
            "        },\n" +
            "        \"type\": \"PAGE\"\n" +
            "    }\n" +
            "}";
    static final String diff2 = "15:37:42 INFO  Utilities - Trigger in Json :\n" +
            "{\n" +
            "    \"failures\": null,\n" +
            "    \"transactionIds\": null,\n" +
            "    \"triggers\": [\n" +
            "        {\n" +
            "            \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "            \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "            \"sequences\": [\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"down\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                \"delay\": \"0.25\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                \"delay\": \"0.5\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"horizontal\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "            \"properties\": {\n" +
            "                \"name\": \"Pick an event 1\"\n" +
            "            },\n" +
            "            \"type\": \"onclick\",\n" +
            "            \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"type\": null\n" +
            "}\n" +
            "15:37:42 INFO  Utilities - Chapter content :\n" +
            "{\n" +
            "    \"content\": {\n" +
            "        \"styleId\": \"e69df92a9fe84451bf1d6e752075b69a\",\n" +
            "        \"id\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "        \"widgets\": [\n" +
            "            {\n" +
            "                \"id\": \"19cfeb0a10b84fe1960305b965aae748\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 1\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    {\n" +
            "                        \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"sequences\": [\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"down\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                            \"delay\": \"0.25\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                            \"delay\": \"0.5\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"horizontal\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"properties\": {\n" +
            "                            \"name\": \"Pick an event 1\"\n" +
            "                        },\n" +
            "                        \"type\": \"onclick\",\n" +
            "                        \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"0\",\n" +
            "                    \"y\": \"78\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"286\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 1\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"3a777c7daa054a569b9c6025d0f38cac\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#8acf58\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"210\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"129\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"c59f59306b8341bbb2cfff4eea834ff7\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ffbc29\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"1\",\n" +
            "                    \"y\": \"210\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"129\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 3\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"7fea852b8edf4836b941170b82119001\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#a0a0a0\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"77c487ba8e454c6ba61c6e39df84ac03\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ff0000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"2\",\n" +
            "                    \"y\": \"218\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"656\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 2\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"f976d78a11ac48f08509b9e37457e8ef\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#00adef\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"a21fa9428df640e0a513727ac791bc21\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#b00000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"3\",\n" +
            "                    \"y\": \"219\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"397\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"9c7b5c53a737447da7f9179c361aabc8\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 3\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"4\",\n" +
            "                    \"y\": \"86\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"767\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "        \"name\": \"Case 1\",\n" +
            "        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "        \"triggers\": [\n" +
            "            \n" +
            "        ],\n" +
            "        \"properties\": {\n" +
            "            \"clip\": \"Horizontal\",\n" +
            "            \"height\": \"600\",\n" +
            "            \"horizontalScroll\": \"Auto\",\n" +
            "            \"width\": \"1000\",\n" +
            "            \"align\": \"Fit to window\",\n" +
            "            \"verticalScroll\": \"Auto\",\n" +
            "            \"media\": \"page\"\n" +
            "        },\n" +
            "        \"type\": \"PAGE\"\n" +
            "    }\n" +
            "}";


}
