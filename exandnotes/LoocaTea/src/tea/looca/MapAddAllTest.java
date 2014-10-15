package tea.looca;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapAddAllTest {

	public static void main(String[] args) {
		// TODO To observe if addAll will replace values of shared keys, add new keys.
		// PASS
		Map<String, String> linkedHashMapStrStr = new LinkedHashMap<String,String> ();
		
		for (int i=0; i<30; i++) {
			linkedHashMapStrStr.put(""+i, "UHL"+i);
		}
		Map<String, String> secondMap = new LinkedHashMap<String,String> ();
		for (int i=12; i<45; i++) {
			secondMap.put(""+i, "AIC"+i);
		}
		linkedHashMapStrStr.putAll(secondMap);
		
		for (Entry<String,String> entry:linkedHashMapStrStr.entrySet() ){
			System.out.println(entry.getKey()+"\t"+ entry.getValue());
			
		}

	}

}
