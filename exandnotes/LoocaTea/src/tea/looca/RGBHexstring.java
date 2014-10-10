package tea.looca;

public class RGBHexstring {

	   public static String changeHexStringToRGBAString(String rgb) {
	        String result = null;
	        if (rgb != null && rgb.length() == 6) {
	            String r = rgb.substring(0, 2);
	            String g = rgb.substring(2, 4);
	            String b = rgb.substring(4, 6);
	            result = "rgba(" + Integer.parseInt(r, 16) + ", " + Integer.parseInt(g, 16) + ", "
	                    + Integer.parseInt(b, 16) + ", 1)";
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(changeHexStringToRGBAString ("ABCDEF") );
		System.out.println(changeHexStringToRGBAString ("f491fe") );

	}

}
