package tea.looca;

import java.util.HashSet;
import java.util.Set;

public class SetContainsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String>  strSet= new HashSet<String> ();
		
		for (int i = 0; i<1000000;i++) {
			strSet.add(""+i);
		}
		int m = 0;
		for (int i = 100; i< 1000000; i+=100) {
			if (strSet.contains(""+i)) {
				System.out.println("True" + ++m);
			}
		}
		String str0 = "100";
		System.out.println(strSet.contains(str0));

	}

}
