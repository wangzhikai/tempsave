package tea.looca;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {

		Object [][]  oj2a = {{1,2,3},{4,5,6}};
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 1; i<=6; i++) {
			li.add(i);
		}
		li.toArray(new Integer[li.size()]);
	}

}
