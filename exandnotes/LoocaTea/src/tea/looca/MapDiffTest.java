package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapDiffTest {

	public static void main(String[] args) {
		Map<String, String> map1 = new LinkedHashMap<String,String> ();
		Map<String, String> map2 = new LinkedHashMap<String,String> ();
		
		for (int i = 0; i< 5; i++) {
			map1.put(""+i,""+i);
		}
		for (int i =2; i< 7; i++) {
			map2.put(""+i,""+i);
		}
		System.out.println(diffTwoMapsKeyset(map1, map2));
		System.out.println(diffTwoMapsKeyset(map2, map1));
	}
	public static String diffTwoMapsKeyset(final Map a, final Map b) {
		Map a1 = new LinkedHashMap();
		Map b1 = new LinkedHashMap();
		a1.putAll(a);
		b1.putAll(b);
		a1.keySet().removeAll(b1.keySet());
		Set t = new TreeSet();
		t.addAll(a1.keySet());
		String result = "";
		for (Object o: t) {
			result += o.toString() + " ";
		}
		return result;
	}

}
//0 1 
//5 6 


