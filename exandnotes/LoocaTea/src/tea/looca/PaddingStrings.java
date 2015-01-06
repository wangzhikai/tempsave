package tea.looca;

import java.util.Arrays;

public class PaddingStrings {
	/**
	 * @param input
	 * @param c
	 * @param width - positive right padding, other wise left padding.
	 * @return
	 */
	public static String padAString(String input, char c, int width) {
		String result = input;
		if (Math.abs(width) > input.length()) {
			StringBuffer sb = new StringBuffer();
			// sb.append(input);
			char array[] = new char[Math.abs(width) - input.length()];
			Arrays.fill(array, c);
			sb.append(array);
			if (width < 0) {
				sb.append(input);
			} else {
				sb.insert(0, input);
			}
			result = sb.toString();
		}
		return result;
	}

	public static void main(String[] args) {
		String input = "abcdefg";
//i=-1
//		Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -1
//		at java.lang.String.substring(String.java:1904)
//		at tea.looca.PaddingStrings.main(PaddingStrings.java:34)
		
		//[start_index,end_index)
		System.out.println(input.substring(0, input.length()-1));//abcdef
		System.out.println(input.substring(0, input.length()));//abcdefg
		System.out.println(input.substring(input.length()-1, input.length()-1));//""
		System.out.println(input.substring(input.length(), input.length()));//""
		//System.out.println(input.substring(4, 3));//String index out of range: -1
		
//		System.out.println(input.substring(0, input.length()+1));
//		//System.out.println(input.substring(0, input.length()+2));
//		Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 8
//		at java.lang.String.substring(String.java:1907)
//		at tea.looca.PaddingStrings.main(PaddingStrings.java:39)

		System.out.println("=====");
		for (int i = 0; i<=input.length(); i++) {
			for (int j = i ; j<= input.length(); j++) {
				System.out.println(padAString(input.substring(i, j),'-',-10));
			}
		}
		System.out.println("=====");
		for (int i = 0; i<=input.length(); i++) {
			for (int j = i ; j<= input.length(); j++) {
				System.out.println(padAString(input.substring(i, j),'-',10));
			}
		}
		

	}
}
