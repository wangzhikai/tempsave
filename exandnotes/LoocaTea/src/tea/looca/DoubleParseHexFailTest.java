package tea.looca;

public class DoubleParseHexFailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Double.parseDouble("0x1a"));

	}

}
//Exception in thread "main" java.lang.NumberFormatException: For input string: "0x1a"
//	at sun.misc.FloatingDecimal.parseHexString(FloatingDecimal.java:1904)
//	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1072)
//	at java.lang.Double.parseDouble(Double.java:540)
//	at tea.looca.DoubleTextFormatTest.main(DoubleTextFormatTest.java:7)
