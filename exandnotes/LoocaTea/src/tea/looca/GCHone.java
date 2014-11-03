package tea.looca;

import java.util.ArrayList;
import java.util.List;

public class GCHone {

	public static void main(String[] args) {
		int c = 0;
		while (true) {
			List<Integer> tmpl = new ArrayList<Integer>();
			for (int i = 10000000; i < 20000000; i++) {
				tmpl.add(i);
			}		
			System.out.println(""+(++c));
		}
	}
}
