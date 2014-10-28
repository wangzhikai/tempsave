package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapValuesTest {

	public static void main(String[] args) {
		Map<String,Integer> siMap = new LinkedHashMap <String, Integer> ();

		for (int i = 0; i<= 100; i++) {
			siMap.put(""+i,i%17);
		}
		
		for (int i:siMap.values()) {
			System.out.println(i);
		}
		// RUNTIME exception: System.out.println(1%0);
		Integer i;

	}

}
