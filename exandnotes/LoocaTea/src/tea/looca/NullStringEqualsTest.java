package tea.looca;

public class NullStringEqualsTest {

	public static void main(String[] args) {
		String s1 = null;
		String s2 = null;
		System.out.println(s1==s2);
		//System.out.println(s1.equals( s2));// exception
		
		String s3 = "Good developer TESTs it first.";
		String s4 = new String(s3);
		String s5 = s3;
		System.out.println ("s3 == s4 : " + (s3 == s4)); // must bracket s3 == s4
		System.out.println ("s3.equals(s4) : " + s3.equals(s4));
		System.out.println ("s3 == s5 : " + (s3 == s5));
		System.out.println ("s3.equals(s5) : " + s3.equals(s5));
		/*OUTPUT 
s3 == s4 : false
s3.equals(s4) : true
s3 == s5 : true
s3.equals(s5) : true
		 */

		   /*
		//TODO Experiment about double equal.Remove from git branch. This groovy '==' is not very trust-worthy
		String s1
		String s2
		log.info "s1 ? s2 = "+(s1==s2)


		public static void main(String[] args) {
		    String s1 = null;
		    String s2 = null;
		    System.out.println(s1==s2);
		    System.out.println(s1.equals( s2));

		}
		*/
	}

}
