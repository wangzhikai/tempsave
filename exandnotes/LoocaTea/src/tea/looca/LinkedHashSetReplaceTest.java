package tea.looca;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashSetReplaceTest {
	public static void main(String[] args) {
		/**
		 * TODO QUESTION Java LinkedHashSet can replace a given node, without alternating the iteration sequence?
		 * TODO ANSWER: No.
		 * TODO QUESTION Java LinkedHashMap?
		 * TODO GUESS: Yes. 
		 * TODO ANSWER: Yes.
		 * TOOD NOTE: Basically, set is not preferably less advantageous than map. 
		 */
		Map<String, String> hashMapStrStr = new HashMap<String,String> ();
		Map<String, String> linkedHashMapStrStr = new LinkedHashMap<String,String> ();
		
		for (int i=0; i<30; i++) {
			hashMapStrStr.put(""+i, "AIC"+i);
			linkedHashMapStrStr.put(""+i, "AIC"+i);
		}
		System.out.println("==hashMapStrStr==");
		for (Entry<String, String> entry : hashMapStrStr.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		System.out.println("==linkedHashMapStrStr==");
		for (Entry<String, String> entry : linkedHashMapStrStr.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}		
		linkedHashMapStrStr.put("26", "DSM02");
		System.out.println("==linkedHashMapStrStr==");
		for (Entry<String, String> entry : linkedHashMapStrStr.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}			
		
		
		System.out.println("=====");
		Set<String> setStr = new LinkedHashSet<String> ();
		for (int i = 0; i<30; i++) {
			setStr.add(""+i);
		}

		for (String s : setStr) {
			System.out.println(s);
		}
		Object arrayStr =  setStr.toArray();
		System.out.println( setStr.toArray().getClass());

		System.out.println(arrayStr.getClass());
		System.out.println(arrayStr);
		Iterator<String> it = setStr.iterator();
		
	}

}
