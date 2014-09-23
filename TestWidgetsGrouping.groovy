package com.irise.testng.featureTests

import com.irise.Chapter
import com.irise.Common
import com.irise.Content
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
    @Test
    def void dosth () {
        def cid =  ""
        //resp = chapter.getAll(projid)
        String ccid = "﻿chapter1411434527297"
        // TODO ASSERT
        assertEquals (ccid, "﻿chapter1411434527297","NOT EQUAL");
    }

    @Test(groups = ["feature"])
    def void testLoadIdocAndVerifyGroup() {
        def resp
        def project = new Project()
        def chapter = new Chapter()

        def common = new Common()
        //common.setup()




        def idoc = new IDoc()
        def filename = "testData/GroupedWidgets.idoc"
        resp = idoc.upload("GroupedWidgets", "", filename, "GroupedWidgets.idoc")
        assertEquals(resp.status, 201, "idoc file not loaded")

        resp = project.getAll()
        // TODO assert resp -- correct status && resp resp.responseData > 0
        // assert resp[responseData] ["projects"]

        //print resp["responseData"] ["projects"]
        //def projname = ""
        def projid = ''
        for ( e in resp["responseData"] ["projects"] ) {
            //x += e.value

//            if ("GroupedWidgets".equalsIgnoreCase(e["projectName"])) {
//                projid = e["projectId"]
//                break;
//            }
            if ( 'GroupedWidgets' == e["projectName"] ) {
                projid = e["projectId"]
                break
            }
        }
        //TODO assert projid valid
        //println("show projid\n")
        //print projid

        // read chapters from project
        // find "﻿chapter1411434527297"

        def cid =  ''
        resp = chapter.getAll(projid)
        def ccidnm = "chapter1411434527297"
        def eid
        def echptid
        def tstr
        def econtentid
        // TODO ASSERT
        for ( def e in resp["responseData"] ["chapters"] ) {
            eid = e["id"]
            echptid = e["content"]["chapterId"]
            econtentid = e["content"]["id"]
            tstr = e["name"]
            println ()
            println ccidnm
            println tstr
            println eid
            println echptid
            println econtentid


//            if (ccid.equalsIgnoreCase(str)) {
//                cid = e["id"]
//                break;
//            }
            //if ( String.CaseInsensitiveComparator.compare (ccid,tstr) == 0  ) {
            //if (ccid.equalsIgnoreCase(tstr)) {
            if ( ccidnm.equals(tstr) ) {
                //println "EQUAL CASE"
                //cid = eid
                cid = econtentid
                break;
            }
        }

        //def chptids =  chapter.getAllChapterIds(resp)
        // TODO ASSERT

        // TODO ASSERT CHPTID  VALID
        println "cid"

        println cid




        def widget = new Widget()
        //widget.get()


        // read widets from a chapter

//        //println "chapter id $chapterId project id $projectId content id $contentId"
        println "content"
        def content = new Content()
//        // given the content on the chapter
        resp = content.get(projid, cid)
        assertEquals(resp.status, 200, "fail get content")

        for ( def e in resp["responseData"] ["content"]["widgets"] ) {
            println  e["name"]

        }



        // iterate the widgets TODO assert all widgets GID == [0]



        common.deleteAllProjects();


    }
}
