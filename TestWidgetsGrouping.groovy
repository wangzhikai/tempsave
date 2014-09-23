package com.irise.testng.featureTests

import com.irise.Chapter
import com.irise.Common
import com.irise.IDoc
import com.irise.Project
import com.irise.Widget
import groovy.json.JsonBuilder
import groovy.util.logging.Log4j
import org.testng.annotations.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
import static org.testng.Assert.assertEquals

/**
 * Created by zwang on 9/22/14.
 */
class TestWidgetsGrouping {
    /**
     * Test read all widgets from a project, chapter, container etc. Each widget has valid gid, UUID or null.
     * Test delete widgets one by one from group with more than three widgets.
     * - Verify when N >= 2, the group is still valid.
     * - Verify since N = 1, the group is deleted.
     * Test delete all widgets from a group, the group is deleted.
     * Test delete N-1 widgets from a group, the group is deleted.
     */

    def menulist = [[type: "MENU_ITEM", properties: [showOn: "Hover", showIfCurrent: "true", text: "Save"]],
                    [type: "MENU_ITEM", properties: [showOn: "Hover", showIfCurrent: "true", text: "File"]]
    ]
    def tilelist = [[type: "TILE", properties: [width: "10", height: "10"]]]
    def stdProp = [x: "10", y: "10", push: "true", hidden: "false"
    ]


    def void createNSetsofWidgets(Common common, int N) {
        def widget = new Widget()
        def json, widgetId
        def resp, root, prop
        //for (int i=0; i<N; i++) {
        def wlist = common.widgetTypeList()
        wlist.each { k ->
            // make with optional properties
            //log.info("working on $k")
            root = [:]
            root["name"] = k
            root["type"] = k
            root["containerKey"] = common.containerKey
            if (k == "MENU") {
                root["children"] = menulist
            }
            if (k == "TILE_LIST") {
                root["children"] = tilelist
            }
            prop = [:]
            prop += common.requiredCreateWidget(k)
            root["properties"] = prop
            json = new JsonBuilder(root)
            //println "into widget create ${json.toString()}"
            resp = widget.create(common.projectId, json.toString())
            assertEquals(resp.status, 201, "fail create ${k} widget ${resp.status} ${prettyPrint(toJson(resp.data))}")
            //widgetId = widget.getWidgetId(resp, 0)
            //resp = widget.delete(common.projectId, widgetId)
        }
        //}
    }


    // Add widgets to a project, gvien the API not completed.
    // We have to use legacy studio to group the widgets, then export the iDoca.
    // This is not necessarily a test.
    //@Test(groups = ["feature"])
    def void testCreateAProjectwithWidgetstoGroup() {
        def common = new Common()
        common.setup()

        // Create 4 suites of widgets according to Widgets list
        createNSetsofWidgets(common, 4)

        // Delete the project manually.
    }

    @Test(groups = ["feature"])
    def void testLoadIdocAndVerifyGroup() {
        def common = new Common()
        common.setup()


        def idoc = new IDoc()
        def filename = "testData/GroupedWidgets.idoc"
        resp = idoc.upload("GroupedWidgets", "", filename, "GroupedWidgets.idoc")
        assertEquals(resp.status, 201, "idoc file not loaded")

        resp = project.getAll()

        common.e


    }
}
