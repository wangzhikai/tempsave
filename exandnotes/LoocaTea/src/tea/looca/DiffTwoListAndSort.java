package tea.looca;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DiffTwoListAndSort {

	public static void main(String[] args) {
		String [] a1 = {"t","c","f","g","a"};
		String [] a2 = {"g","h","c","o","q"};
		List l1 = Arrays.asList(a1);
		List l2 = Arrays.asList(a2);
		System.out.println(diffTwoListsAndSort(l1,l2));
		System.out.println(diffTwoListsAndSort(l2,l1));
		System.out.println(diffTwoListsAndSort(l2,l2));
	}
	public static String diffTwoListsAndSort(final List a, final List b) {
		String result = "";
		Set s1 = new TreeSet();
		s1.addAll(a);
		Set s2 = new TreeSet();
		s2.addAll(b);
		s1.removeAll(s2);
		for (Object o: s1) {
			result += o.toString() + " ";
		}
		return result;
		
		/*
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
		*/
	}

}
