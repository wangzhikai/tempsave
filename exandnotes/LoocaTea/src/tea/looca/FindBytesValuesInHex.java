package tea.looca;

public class FindBytesValuesInHex {

	public static void main(String[] args) {
		String s = "PATCH";
		for (int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			System.out.println(Integer.toHexString(c));
			
		}
	}

}
