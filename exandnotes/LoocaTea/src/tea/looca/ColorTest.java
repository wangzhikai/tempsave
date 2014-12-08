package tea.looca;

import java.util.Calendar;

public class ColorTest {
	public static String getARandom256RGBString () {
		String guard = "000000";
		String freight = Integer.toHexString((int) (Math.random()*(0xffffff+1)));
		String tmp = freight;
		for (int i = 0; i<guard.length() - freight.length() ; i++ ) {
			tmp = "0"+tmp;
		}
		return tmp;
	}
	public static String getARandom256RGBStringBeginWithAmpersand () {
		return "#"+getARandom256RGBString ();
	}
	public static void main(String[] args) {
		long start = Calendar.getInstance().getTimeInMillis();
		Integer i = new Integer(255);
		System.out.println(i.toHexString(i).toUpperCase());
		System.out.println(Integer.MAX_VALUE);
		for (int c = 0; c<=Integer.MAX_VALUE/10000; c++) {
			String str = getARandom256RGBStringBeginWithAmpersand ();
			str = str.replaceAll("#", "");
			if (c%10000 == 0) {
				System.out.println(str + "\t"+c);
			}
			int t = Integer.parseInt(str,16);
			if (t > 0xffffff || t<0 || str.length() != 6) {
				System.err.println("You design failed.");
				break;
			}
			
		}
		System.out.println("It takes "+( Calendar.getInstance().getTimeInMillis()- start) +" milli-seconds");

	}

}
