package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeakMapReferenceTest {
	
	// Java vs. Groovy 20141209

	public static void main(String[] args) {
		Map map = new <Object,Object> LinkedHashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3".toString(),"value3");
        Object key4 = "key4";
        map.put(key4,"value4");
        System.out.println( map.get("key1") );
        System.out.println( map.get("key3") );
        System.out.println( map.get("key4") );
        Object ctype = "page";
        Object chapterName = ctype+"_SOURCE";
        map.put(chapterName,null);
        map.put(chapterName,"value5");
        System.out.println(  map.get(chapterName) );
        System.out.println(  map.get("page_SOURCE") );
        System.out.println(  map.get(new String("page_SOURCE")) );
   /*     
        // Partial answer to this question : sourceChaptersNamesIdsMap["PAGE_SOURCE"] == null?
        // TODO Why this line fails the test  -- sourceChaptersNamesIdsMap.put(chapterName, null)
        // TODO Why this line does not fail the test  -- sourceChaptersNamesIdsMap.put(chapterName.toString(), null)!
        Map map = [:]
        map.put("key1","value1")
        map.put("key2","value2")
        map.put("key3".toString(),"value3")
        def key4 = "key4"
        map.put(key4,"value4")
        log.info map.get("key1")
        log.info map.get("key3")
        log.info map.get("key4")
        def ctype = "page"
        def chapterName = "${ctype}_SOURCE"//groovy.lang.MetaClassImpl@4fd24389[class org.codehaus.groovy.runtime.GStringImpl] evaluated <"${ctype}_SOURCE">
        map.put(chapterName,null)
        map.put(chapterName,"value5")
        log.info map.get(chapterName)
        log.info map.get("page_SOURCE") // BINGO this one hits a null. <"page_SOURCE"> evaluates as {java.lang.String@2588}"page_SOURCE"
*/

	}
	//round 1 K.O., maybe there is an excuse. We use these tools to make a living! please. No excuse.

}
