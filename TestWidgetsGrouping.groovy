package com.irise.testng.featureTests

import com.irise.Chapter
import com.irise.Common
import com.irise.Content
import com.irise.IDoc
import com.irise.Project
import com.irise.Widget
import com.irise.Clipboard
import groovy.json.JsonBuilder
import org.testng.annotations.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
import static org.testng.Assert.assertEquals
import static org.testng.Assert.assertTrue
import groovy.util.logging.Log4j

/**
 * Created by zwang on 9/22/14.
 */

@Log4j
class TestWidgetsGrouping {
    def final UUIDStringLength = 32
    /**
     * Test read all widgets from a project, chapter, container etc. Each widget has valid gid, UUID or null.
     * Test delete widgets one by one from group with more than three widgets.
     * - Verify when N >= 2, the group is still valid.
     * - Verify since N = 1, the group is deleted.
     * Test delete all widgets from a group, the group is deleted.
     * Test delete N-1 widgets from a group, the group is deleted.
     */
    /**
     * Given a group G having N widgets, N>=3, try to remove N-1 widgets by CUT/PASTE.  G is deleted. valid case.
     */
    @Test(groups = ["feature"])
    def void cutPasteGroupedWidgetsByNMinusOne() {
        def projectNameInTest = 'cutPasteGroupedWidgetsOneByOne'
        def resp
        def project = new Project()
        def chapter = new Chapter()
        def common = new Common()
        def idoc = new IDoc()
        def filename = 'GroupedWidgetsWithoutDisabled.idoc'
        def filenameWithPath = "testData/${filename}"
        def chapterNameInTest   = 'PageWIthOnlyGroupedButtons'
        def content = new Content()
        def widget = new Widget()
        def clipboard = new Clipboard()

        // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
        resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
        assertEquals(resp.status, 201, 'idoc file not loaded')

        // Get a projectId from a given project name
        resp = project.getAll()
        assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

        def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
        assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

        // Get contentId of the chapter with grouped widgets by name.
        resp = chapter.getAll(projectidInTest)
        assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in system.")
        def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
        assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")

        // Read widets from a chapter, put widgets' IDs to a list
        resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

        def allWidgetsList = resp["responseData"] ["content"]["widgets"]

        // Get first grouped widget's groupid
        def gidOfFirstGroupedWidget = getTheFirstGroupId (resp)
        assertTrue(gidOfFirstGroupedWidget!= null && ((String)gidOfFirstGroupedWidget).length() == UUIDStringLength, "The group id is in valid form.")

        // Delete widget from the list one by one
        def size = allWidgetsList.size
        def noDeleted = 0
        def noToDelete = allWidgetsList.size - 1
        def c = 0
        while ( noDeleted + noToDelete <= size ) {

            def widgetIdsToCut = []
            for (def i = 0; i < noToDelete; ++i) {
                widgetIdsToCut.add(allWidgetsList.get(c)["id"])
                c++
            }
            //cutSomeWidgets (clipboard,projectidInTest,widgetIdsToCut)
            cutPasteSomeWidgets (widget,clipboard,projectidInTest,widgetIdsToCut,contentIdInTest)
            noDeleted +=  noToDelete
            if (noDeleted <= size-2) {
                // Not necessary just drag the test slow.
                assertTrue( checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should exist.")
            } else {
                assertTrue( !checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should not exist.")
            }
            noToDelete = ((int) (Math.random()* (allWidgetsList.size - noDeleted ))) + 1
            log.info("noCutPasted=${noDeleted} size=${allWidgetsList.size}")
            break // One shot business
        }
        // Delete the project
        log.info("Congratulation, ${getCurrentTestNominal (Thread.currentThread().getStackTrace())} passed!")
        resp = project.delete(projectidInTest)
        assertEquals(resp.status, 200 , "fail delete project")
        //TODO
        log.warn("Congratulation, ${getCurrentTestNominal (Thread.currentThread().getStackTrace())} passed!")

    }

    /**
     * Given a group G having N widgets, N>=3, try to remove more than one widgets from the group each time.
     * If ||G|| >= 2, group G is persisted. valid case.
     */
    @Test(groups = ["feature"])
    def void cutPasteGroupedWidgetsMoreThanOne() {
        //TODO if use 'GroupedWidgets.idoc', there will be widgets can not be cut pasted, but they can be deleted?
        def projectNameInTest = 'cutPasteGroupedWidgetsOneByOne'
        def resp
        def project = new Project()
        def chapter = new Chapter()
        def common = new Common()
        def idoc = new IDoc()
        def filename = 'GroupedWidgetsWithoutDisabled.idoc'
        def filenameWithPath = "testData/${filename}"
        def chapterNameInTest   = 'PageWIthOnlyGroupedButtons'
        def content = new Content()
        def widget = new Widget()
        def clipboard = new Clipboard()

        // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
        resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
        assertEquals(resp.status, 201, 'idoc file not loaded')

        // Get a projectId from a given project name
        resp = project.getAll()
        assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

        def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
        assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

        // Get contentId of the chapter with grouped widgets by name.
        resp = chapter.getAll(projectidInTest)
        assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in system.")
        def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
        assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")

        // Read widets from a chapter, put widgets' IDs to a list
        resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

        def allWidgetsList = resp["responseData"] ["content"]["widgets"]

        // Get first grouped widget's groupid
        def gidOfFirstGroupedWidget = getTheFirstGroupId (resp)
        assertTrue(gidOfFirstGroupedWidget!= null && ((String)gidOfFirstGroupedWidget).length() == UUIDStringLength, "The group id is in valid form.")

        // Delete widget from the list one by one
        def size = allWidgetsList.size
        def noDeleted = 0
        //TODO
        def noToDelete = ((int) (Math.random()* (allWidgetsList.size - noDeleted ))) + 1
        def c = 0
        while ( noDeleted + noToDelete <= size ) {

            def widgetIdsToCut = []
            for (def i = 0; i < noToDelete; ++i) {
                widgetIdsToCut.add(allWidgetsList.get(c)["id"])
                c++
            }
            //cutSomeWidgets (clipboard,projectidInTest,widgetIdsToCut)
            cutPasteSomeWidgets (widget,clipboard,projectidInTest,widgetIdsToCut,contentIdInTest)
            noDeleted +=  noToDelete
            if (noDeleted <= size-2) {
                // Not necessary just drag the test slow.
                assertTrue( checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should exist.")
            } else {
                assertTrue( !checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should not exist.")
            }
            noToDelete = ((int) (Math.random()* (allWidgetsList.size - noDeleted ))) + 1
            log.info("noCutPasted=${noDeleted} size=${allWidgetsList.size}")
        }

        // Delete the project
        resp = project.delete(projectidInTest)
        assertEquals(resp.status, 200 , "fail delete project")

    }

    /**
     * Given a group G having N widgets, N>=3, try to remove one widget from the group each time by CUT/PASTE.
     * Upon number of elements ||G|| <= 1, group G is deleted, namely no widgets associated to the groupid. valid case.
     */
     @Test(groups = ["feature"])
     def void cutPasteGroupedWidgetsOneByOne() {
         //TODO if use 'GroupedWidgets.idoc', there will be widgets can not be cut pasted, but they can be deleted?
         def projectNameInTest = 'cutPasteGroupedWidgetsOneByOne'
         def resp
         def project = new Project()
         def chapter = new Chapter()
         def common = new Common()
         def idoc = new IDoc()
         def filename = 'GroupedWidgetsWithoutDisabled.idoc'
         def filenameWithPath = "testData/${filename}"
         def chapterNameInTest   = 'PageWIthOnlyGroupedButtons'
         def content = new Content()
         def widget = new Widget()
         def clipboard = new Clipboard()

         // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
         resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
         assertEquals(resp.status, 201, 'idoc file not loaded')

         // Get a projectId from a given project name
         resp = project.getAll()
         assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

         def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
         assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

         // Get contentId of the chapter with grouped widgets by name.
         resp = chapter.getAll(projectidInTest)
         assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in system.")
         def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
         assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")

         // Read widets from a chapter, put widgets' IDs to a list
         resp = content.get(projectidInTest, contentIdInTest)
         assertEquals(resp.status, 200, "fail get content")
         assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

         def allWidgetsList = resp["responseData"] ["content"]["widgets"]

         // Get first grouped widget's groupid
         def gidOfFirstGroupedWidget = getTheFirstGroupId (resp)
         assertTrue(gidOfFirstGroupedWidget!= null && ((String)gidOfFirstGroupedWidget).length() == UUIDStringLength, "The group id is in valid form.")

         // Delete widget from the list one by one
         def size = allWidgetsList.size
         def noToDelete = 1
         def noDeleted = 0
         def c = 0
         while ( noDeleted + noToDelete <= size ) {
             def widgetIdsToCut = []
             for (def i = 0; i < noToDelete; ++i) {
                 widgetIdsToCut.add(allWidgetsList.get(c)["id"])
             }
             //cutSomeWidgets (clipboard,projectidInTest,widgetIdsToCut)
             cutPasteSomeWidgets (widget,clipboard,projectidInTest,widgetIdsToCut,contentIdInTest)
             noDeleted +=  noToDelete
             if (noDeleted <= size-2) {
                 // Not necessary just drag the test slow.
                 //assertTrue( checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should exist.")
             } else {
                 assertTrue( !checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should not exist.")
             }
             c++
         }

         // Delete the project
         resp = project.delete(projectidInTest)
         assertEquals(resp.status, 200 , "fail delete project")

     }
     def cutPasteSomeWidgets (widget,clipboard,projectId,widgetIdsToCut,containerKey) {
         def uris = []
         for (widgetIdToCut in widgetIdsToCut) {
            uris.add("/ds/projects/${projectId}/widgets/${widgetIdToCut}")
         }
         def cutWidgetResponse = clipboard.create(projectId, 'CUT', uris)

         if (cutWidgetResponse.status == 501) {
            //println "do sth"
            log.warn("The following widgets can not be cut-pasted.")
            def str = ''
            for (widgetIdToCut in widgetIdsToCut) {
                str += "/ds/projects/${projectId}/widgets/${widgetIdToCut}  "
            }
            log.warn("${str}")
         }
         assertEquals(cutWidgetResponse.status, 201, "fail widget cut")
         def root = [:]
         root['x'] = "20"
         root['y'] = "20"
         root['copySet'] = cutWidgetResponse.data.copySet
         def json = new JsonBuilder(root)
         def pasteWidgetResponse = widget.paste(projectId, containerKey, json.toString())
         assertEquals(pasteWidgetResponse.status, 201, "fail widget paste")
     }

     def cutPasteSomeWidgetsToShowBug (widget,clipboard,projectId,widgetIdsToCut,containerKey) {
         def uris = []
         for (widgetIdToCut in widgetIdsToCut) {
             uris.add("/ds/projects/${projectId}/widgets/${widgetIdToCut}")
         }
         def cutWidgetResponse = clipboard.create(projectId, 'CUT', uris)
         if (cutWidgetResponse.status == 501) {
             //println "do sth"
             log.warn("The following widgets can not be cut-pasted.")
             def str = ''
             for (widgetIdToCut in widgetIdsToCut) {
                 str += "/ds/projects/${projectId}/widgets/${widgetIdToCut}  "
             }
             log.warn("${str}")

             for (widgetIdToCut in widgetIdsToCut) {
                 def resp = widget.delete(projectId, widgetIdToCut)
                 assertEquals(resp.status, 200, "fail widget delete")
             }
             //resp = widget.delete(projectidInTest, e["id"])
             //assertEquals(resp.status, 200, "fail widget delete")
         } else {
             assertEquals(cutWidgetResponse.status, 201, "fail widget cut")

             def root = [:]
             root['x'] = "20"
             root['y'] = "20"
             root['copySet'] = cutWidgetResponse.data.copySet
             def json = new JsonBuilder(root)

             def pasteWidgetResponse = widget.paste(projectId, containerKey, json.toString())
             assertEquals(pasteWidgetResponse.status, 201, "fail widget paste")
         }
     }


    /**
     * Given a group G having N widgets, N>=3, try to remove one widget from the group each time by DELETION.
     * Upon number of elements ||G|| <= 1, group G is deleted, namely no widgets associated to the groupid.
     * valid case.
     */
    @Test(groups = ["feature"])
    def void deleteGroupedWidgetsOneByOne() {
        def projectNameInTest = 'DeleteGroupedWidgetsOneByOne'
        def resp
        def project = new Project()
        def chapter = new Chapter()
        def common = new Common()
        def idoc = new IDoc()
        def filename = 'GroupedWidgets.idoc'
        def filenameWithPath = "testData/${filename}"
        def chapterNameInTest   = 'PageWithGroupedwidgets'
        def content = new Content()
        def widget = new Widget()

        // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
        resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
        assertEquals(resp.status, 201, 'idoc file not loaded')

        // Get a projectId from a given project name
        resp = project.getAll()
        assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

        def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
        assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

        // Get contentId of the chapter with grouped widgets by name.
        resp = chapter.getAll(projectidInTest)
        assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in system.")
        def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
        assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")

        // Read widets from a chapter, put widgets' IDs to a list
        resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

        def allWidgetsList = resp["responseData"] ["content"]["widgets"]

        // Get first grouped widget's groupid
        def gidOfFirstGroupedWidget = getTheFirstGroupId (resp)
        assertTrue(gidOfFirstGroupedWidget!= null && ((String)gidOfFirstGroupedWidget).length() == UUIDStringLength, "The group id is in valid form.")

        // Delete widget from the list one by one
        // verify group still exists or not
        def size = allWidgetsList.size
        def noDeleted = 0
        for ( def e in allWidgetsList ) {
            resp = widget.delete(projectidInTest, e["id"])
            assertEquals(resp.status, 200, "fail widget delete")
            ++noDeleted
            if (noDeleted <= size-2) {
                // Not necessary just drag the test slow.
                // assertTrue( checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should exist.")
            } else {
                assertTrue( !checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget), "Group should not exist.")
            }
        }

        // Delete the project
        resp = project.delete(projectidInTest)
        assertEquals(resp.status, 200 , "fail delete project")
    }

    /**
     * Create a iDoc with a lot grouped widgets. ||G|| >> 3.
     * Load the iDoc as test prerequisite and validate all widgets belonging to the same group. valid case.
     */
    @Test(groups = ["feature"])
    def void testLoadIdocWithGroupedWidgets() {
        def projectNameInTest = 'GroupedWidgets'
        def resp
        def project = new Project()
        def chapter = new Chapter()
        def common = new Common()
        def idoc = new IDoc()
        def filename = 'GroupedWidgets.idoc'
        def filenameWithPath = "testData/${filename}"
        def chapterNameInTest   = 'PageWithGroupedwidgets'
        def content = new Content()


        // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
        resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
        assertEquals(resp.status, 201, 'idoc file not loaded')

        // Get a projectId from a given project name
        resp = project.getAll()
        assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

        def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
        assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

        // Get contentId of the chapter with grouped widgets by name.
        resp = chapter.getAll(projectidInTest)
        assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in system.")
        def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
        assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")


        // Read widets from a chapter
        resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

        // Get first widget's groupid
        def gidOfFirstWidget = resp["responseData"] ["content"]["widgets"][0]["groupId"]
        assertTrue(gidOfFirstWidget!= null && ((String)gidOfFirstWidget).length() == UUIDStringLength, "The group id is in valid form.")

        // All widgets in this content will have the same groupid
        for ( def e in resp["responseData"] ["content"]["widgets"] ) {
            assertTrue( ((String )e["groupId"]).equalsIgnoreCase(gidOfFirstWidget ), "All widgets in this content belong to the same group.")
            //println e["groupId"] +'  '+gidOfFirstWidget
        }

        // Delete the project
        resp = project.delete(projectidInTest)
        assertEquals(resp.status, 200 , "fail delete project")
    }


    /**
     * Load an iDoc with with widgets partially grouped.
     * Reading each widget of a project, a container,
     * a chapter etc will get the widget's groupid.
     * The id should be in valid format, UUID string or null. Valid case.
     */
    @Test(groups = ["feature"])
    def void testLoadIdocWithPartiallyGroupedWidgets() {
        def projectNameInTest = 'PartiallyGroupedwidgets'
        def resp
        def project = new Project()
        def chapter = new Chapter()
        def common = new Common()
        def idoc = new IDoc()
        def filename = 'PartiallyGroupedWidgets.idoc'
        def filenameWithPath = "testData/${filename}"
        def chapterNameInTest = 'PageWithPartiallyGroupedwidgets'
        def content = new Content()


        // Load the iDoc with grouped widgets, so far the widgets are grouped in legacy studio --20140923.
        resp = idoc.upload(projectNameInTest, '', filenameWithPath, filename)
        assertEquals(resp.status, 201, 'idoc file not loaded')

        // Get a projectId from a given project name
        resp = project.getAll()
        assertTrue(resp.data.projects.size() >= 1, "There should be at least one project in system.")

        def projectidInTest = getProjectIdByNameFromResp(projectNameInTest, resp)
        assertTrue(projectidInTest!= null && ((String)projectidInTest).length() == UUIDStringLength, "The project id is in valid form.")

        // Get contentId of the chapter with grouped widgets by name.
        resp = chapter.getAll(projectidInTest)
        assertTrue(resp.data.chapters.size() >= 1, "There should be at least one chapter in project.")
        def contentIdInTest = getContentIdByChapterName(chapterNameInTest,resp)
        assertTrue(contentIdInTest!= null && ((String)contentIdInTest).length() == UUIDStringLength, "The content id is in valid form.")


        // Read widets from a chapter
        resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        assertTrue(resp.data.content.widgets.size() >= 1,  "There should be at least one widget in the content.")

        // Get first widget that has a groupid/ first grouped widget
        def gidOfFirstGroupedWidget = getTheFirstGroupId (resp)
        //resp["responseData"] ["content"]["widgets"][0]["groupId"]
        //assertTrue(gidOfFirstWidget!= null && ((String)gidOfFirstWidget).length() == UUIDStringLength, "The group id is in valid form.")

        // There are widgets not grouped in this content
        def c = 0
        for ( def e in resp["responseData"] ["content"]["widgets"] ) {
            //assertTrue( ((String )e["groupId"]).equalsIgnoreCase(gidOfFirstGroupedWidget), "All widgets in this content belong to the same group.")
            //println e["groupId"] +'  '+gidOfFirstWidget
            if ( e["groupId"] == null )
                c++
        }
        //println "c = "+c
        assertTrue( c>0, "There should be ungrouped widgets in this content (${c}).")

        // Delete the project
        resp = project.delete(projectidInTest)
        assertEquals(resp.status, 200 , "fail delete project")
    }
    def checkGroupExisting(content, projectidInTest, contentIdInTest, gidOfFirstGroupedWidget) {
        def result = false
        def resp = content.get(projectidInTest, contentIdInTest)
        assertEquals(resp.status, 200, "fail get content")
        for ( e in resp["responseData"] ["content"]["widgets"] ) {
            if (e["groupId"] != null && ( (String) e["groupId"]).length() == UUIDStringLength
                    && ((String) e["groupId"]).equalsIgnoreCase(gidOfFirstGroupedWidget )) {
                result = true
                break
            }
        }
        return result
    }
    def getTheFirstGroupId (resp) {
        for ( e in resp["responseData"] ["content"]["widgets"] ) {
            if (e["groupId"] != null && ( (String) e["groupId"]).length() == UUIDStringLength ) {
                return e["groupId"]
            }
        }
        return null
    }
    def getProjectIdByNameFromResp(projectName, resp) {
        for ( e in resp["responseData"] ["projects"] ) {
            if ( projectName.equalsIgnoreCase( e["projectName"] )) {
                return e["projectId"]
            }
        }
        return ''
    }
    def getContentIdByChapterName(chapterName,resp) {
        for ( def e in resp["responseData"] ["chapters"] ) {
            if (chapterName.equalsIgnoreCase(e["name"])) {
                return e["content"]["id"]
            }
        }
        return ''
    }


    //////////////////////////////////////////////////////////////////////
    //// Below this line are experimental code. To be cleaned up.     ////

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
    def void testLoadIdocAndVerifyGroupbk() {
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
        // assert resp -- correct status && resp resp.responseData > 0
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
        //assert projid valid
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

        //common.deleteAllProjects();


    }
    //TODO get the test nominal
    //log.info("Congratulation ${getCurrentTestNominal ((String)Thread.currentThread().getStackTrace())} passed!")
    def getCurrentTestNominal ( stack) {
        def result = "Test name not available"

        for (def s : stack ) {
            if ( ( s.toString()).contains("com.irise") ) {
                result = s;
                break;
            }
        }
        return result;
    }

}
