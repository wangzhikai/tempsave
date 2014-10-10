package tea.looca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOpTest {

	public static void main(String[] args) {
		for (int j = 0; j < 1000; j++) {
			int limit = 1000;
			Set<Integer> widgetsSet1 = new HashSet<Integer>();

			for (int i = 0; i < limit; i++) {
				widgetsSet1.add(i);
			}
			int randomSize = ((int) (Math.random() * (widgetsSet1.size() - 2))) + 2;

			Set<Integer> widgetsSet2 = new HashSet<Integer>();
			List<Integer> tmplist1 = new ArrayList<Integer>();
			tmplist1.addAll(widgetsSet1);
			List<Integer> tmpListOfWidgets = Collections
					.synchronizedList(tmplist1);
			// List <Integer> tmpListOfWidgets =
			// Collections.synchronizedList(new ArrayList().addAll(widgetsSet1))
			// //not working
			for (int i = 0; i < randomSize; i++) {
				int r = ((int) (Math.random() * (tmpListOfWidgets.size())));
				widgetsSet2.add(tmpListOfWidgets.get(r));
				tmpListOfWidgets.remove(r);
			}
			System.out.println("" + tmpListOfWidgets.size() + "\t"
					+ widgetsSet2.size() + "\t" + randomSize);
			if (widgetsSet2.size() !=randomSize ) {
				System.out.println(j);
				break;
			}
		}
	}

}
