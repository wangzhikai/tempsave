package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TODOMapEntryPutAllShallOrDeep {

	public static void main(String[] args) {
		Map<String,String> a = new LinkedHashMap<String,String> ();
		Map<String,String> b = new LinkedHashMap<String,String> ();
		for (int i = 0; i<10; i++) {
			a.put(""+i, "v"+i);
		}
		b.putAll(a);
		
		a.put(""+3,"long jump");
		for (Entry e: a.entrySet()) {
			System.out.println(e.getKey()+" "+ e.getValue());
		}
System.out.println("=========");
		for (Entry e: b.entrySet()) {
			System.out.println(e.getKey()+" "+ e.getValue());
		}
		
		
		
		
		


	}

}
