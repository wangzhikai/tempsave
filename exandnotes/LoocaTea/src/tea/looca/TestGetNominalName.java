package tea.looca;

import java.util.ArrayList;
import java.util.List;

public class TestGetNominalName {
	public static String getNominalName (String str) {
		return str.split("\\.")[str.split("\\.").length -1];
	}
	public static void main(String[] args) {
		String t1 ="sfes";
		String t2 ="p1.sfes";		
		String t3 ="p2.p1.sfes";
		String t4 ="p3.p2.p1.sfes";
		System.out.println(getNominalName(t1));
		System.out.println(getNominalName(t2));
		System.out.println(getNominalName(t3));
		System.out.println(getNominalName(t4));
		List<String > lss = new ArrayList<String>();
		lss.add(t1);
		lss.add(t2);
		lss.add(t3);
		lss.add(t4);
		lss.remove(t4);
	}
}
