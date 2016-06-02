package tea.looca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
//partial revers part in an array

// implementation in Java, array starting index 0

// int len = j-i;

// for (int c = 0; c < len/2; c++ ) {
//   int tmp = a[c+i];
//   a[c+i] = a[i+len-c];
//   a[i+len-c] = tmp;
// }

// save the file as PartialReverse.java
// javac PartialReverse.java
// java PartialReverse
public class PartialReverse {
  
  public static partial_reverse (String [] a, final int i, final int j) {
    // // Second impl, use Java Collection.reverse()
    // assert(j>=i);   

    List<Stirng> tmpl = new ArrayList<String> ();

    for (int c = i; c<=j; c++) {
       tmpl.add(a[c]);
    }

    Collection.reverse(tmpl);

    for (int c=i, c2 = 0; c<=j; c++,c2++) {
      a[c] = tmpl.at (c2 );
    }
  }
  public static main (String [] args ) {
    String [] a = new String [] {"A","B","C","D","E","F" };
    
    System.out.println(a);
    
    partial_reverse(a,2,4);

    // after reverse output:
    System.out.println(a);

  }
}







// TODO REMOVE EMAIL IN text

sed -r . '[ \t]([^@]+)[@].*[ \t|\.|\,]/REMOVED/e{1}'


http://www.regular-expressions.info/email.html


Maybe you're wondering why there's no "official" fool-proof regex to match email addresses. Well, there is an official definition, but it's hardly fool-proof.

The official standard is known as RFC 5322. It describes the syntax that valid email addresses must adhere to. You can (but you shouldn't—read on) implement it with the following regular expression. RFC 5322 leaves the domain name part open to implementation-specific choices that won't work on the Internet today. The regex implements the "preferred" syntax from RFC 1035 which is one of the recommendations in RFC 5322:

\A(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*
  |  "(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]
      |  \\[\x01-\x09\x0b\x0c\x0e-\x7f])*")
@ (?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?
  |  \[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}
       (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:
          (?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]
          |  \\[\x01-\x09\x0b\x0c\x0e-\x7f])+)
     \])\z
 */

public class PartialReverse {
	  public static void partial_reverse (String [] a, final int i, final int j) {
		    // // Second impl, use Java Collection.reverse()
		    // assert(j>=i);   

		    List<String> tmpl = new ArrayList<String> ();

		    for (int c = i; c<=j; c++) {
		       tmpl.add(a[c]);
		    }

		    Collections.reverse(tmpl);

		    for (int c=i, c2 = 0; c<=j; c++,c2++) {
		      //a[c] = tmpl.at (c2 );
		    	a[c] = tmpl.get (c2 );
		    }
		  }
		  public static void main (String [] args ) {
		    String [] a = new String [] {"A","B","C","D","E","F" };
		    
		    //System.out.println(a);
//		    System.out.println(a.toString());
		    for (String s: a) {
		    	System.out.print(s+" ");
		    }
		    System.out.println();
		    partial_reverse(a,2,4);

		    // after reverse output:
		    //System.out.println(a);
		    //System.out.println(a.toString());
		    for (String s: a) {
		    	System.out.print(s+" ");
		    }

		  }
}
