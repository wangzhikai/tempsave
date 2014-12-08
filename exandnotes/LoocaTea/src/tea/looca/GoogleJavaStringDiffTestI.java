package tea.looca;

import java.util.LinkedList;
import java.util.List;

import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;

public class GoogleJavaStringDiffTestI {

	public static void main(String[] args) {
		  String text1 = "name/fraser/neil/plaintext/Speedtest1.txt";
	    String text2 = "name/fraser/neil/plaintext/Speedtest2.txt";

	    diff_match_patch dmp = new diff_match_patch();
	    dmp.Diff_Timeout = 0;

	    // Execute one reverse diff as a warmup.
	    List<Diff> ldiff = dmp.diff_main(text2, text1, false);
	    for (Diff d : ldiff) {
	    	System.out.println(d);
	    }
	    /*This snake has some feet, anyway it works
Diff(EQUAL,"name/fraser/neil/plaintext/Speedtest")
Diff(DELETE,"2")
Diff(INSERT,"1")
Diff(EQUAL,".txt")
	     */

	    ldiff = dmp.diff_main(diff1, diff2, false);
	    for (Diff d : ldiff) {
	    	System.out.println(d);
	    }
	/*
Diff(EQUAL,"name/fraser/neil/plaintext/Speedtest")
Diff(DELETE,"2")
Diff(INSERT,"1")
Diff(EQUAL,".txt")
Diff(EQUAL,""Twinkle twinkle little star\")
Diff(DELETE,"\")
Diff(EQUAL,"n"¶					+ "Twinkle twinkle lttle star\n"¶					+ "+ \"Twinkle twinkle lttle star\n\";"¶			+ "Twinkle twinkle lttle star\n"¶			+ "+ \"Twinkle twinkle lttle star\n\";"¶			+ "Tw")
Diff(DELETE,"i")
Diff(EQUAL,"nkle twinkle lttle star\n"¶			+ "+ \"Twinkle twinkle lttle star\n\";"¶			+ "Twinkle twinkle lttle star\n"¶			+ "+ \"Twinkle twinkle lt")
Diff(INSERT,"i")
Diff(EQUAL,"tle star\n\";";")
<SPAN TITLE="i=0">"Twinkle twinkle little star\</SPAN><DEL STYLE="background:#FFE6E6;" TITLE="i=29">\</DEL><SPAN TITLE="i=29">n"&para;<BR>	    
	 */
    
	    System.out.println(dmp.diff_prettyHtml((LinkedList<Diff>) ldiff));
	}
    public static final String diff1 = "\"Twinkle twinkle little star\\\\n\"\n" +
            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\";";

    public static final String diff2 = "\"Twinkle twinkle little star\\n\"\n" +
            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twnkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle ltitle star\\n\\\";\";";


 
}
