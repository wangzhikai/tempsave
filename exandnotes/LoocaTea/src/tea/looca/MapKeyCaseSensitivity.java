package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapKeyCaseSensitivity {

	public static void main(String[] args) {
		char a = 'a';
		char A = 'A';
		Map<String, Integer> linkedHashMapStrInt = new LinkedHashMap<String, Integer> ();
		
		for (int i=0; i<26; i++) {
			linkedHashMapStrInt.put(""+(a+i), a+i);
			linkedHashMapStrInt.put(""+(A+i), A+i);
		}
		for (int i=0; i<26; i++) {
			System.out.println(linkedHashMapStrInt.get(""+(a+i)));
			System.out.println(linkedHashMapStrInt.get(""+(A+i)));

		}	
        for (int i=0, x=1, y=1;i<100; i++) {
            
        }


	}

}
