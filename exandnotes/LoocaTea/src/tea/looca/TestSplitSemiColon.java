package tea.looca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSplitSemiColon {

	public static void main(String[] args) {
		String[]  ss = {"/ds/projects/projectIdInTest/widgets/cHTML:view",
				"/ds/projects/projectIdInTest/widgets/cHTML:",
				"/ds/projects/projectIdInTest/widgets/cHTML",
				"somehost:8080/ds/projects/projectIdInTest/widgets/cHTML",
				"somehost:8080/ds/projects/projectIdInTest/widgets/cHTML:view"
		};
		for (String s:ss) {
			//System.out.println("Result = "+removeViewTag(s));
			System.out.print(s+"==");
			for (String ts: removeViewTag(s)) {
				System.out.print(ts+"||");
			}
			System.out.println();
		}
		//System.out.println(ss[0].substring(100));// ex
		System.out.println(ss[0].substring(0,0)); //""
		System.out.println(ss[0].substring(0,1)); // "/"
		//System.out.println(ss[0].substring(0,-1));//ex
		

	}
	public static String[] removeViewTag(String input) {
		Pattern p = Pattern.compile("[:][^/]+$");
		Matcher m = p.matcher(input);
//        while (m.find()) {
//            System.out.println(""
//              +  m.group() +" \t "
//              +  m.start()+" \t "
//              ) ;
//        }
//        //return input.split("[:][^/]+$");
        if (m.find())
        	return new String [] {input.substring(0,m.start()),input.substring(m.start())};
        else 
        	return new String [] {input,""};
	}
}
