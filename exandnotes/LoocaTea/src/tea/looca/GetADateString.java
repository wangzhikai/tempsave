package tea.looca;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetADateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SimpleDateFormat("YYYYMMDD").format(Calendar.getInstance().getTime()));
		String s12 = "1234567890";
		String s1 = s12.substring(0,s12.length()/2);
		String s2 = s12.substring(s12.length()/2,s12.length());
		System.out.println(s1);
		System.out.println(s2);
		s12 = "123456789";
		s1 = s12.substring(0,s12.length()/2);
		s2 = s12.substring(s12.length()/2,s12.length());
		System.out.println(s1);
		System.out.println(s2);
	}

}
