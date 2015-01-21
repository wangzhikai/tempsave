package tea.looca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortIgnoreCase {

	public static void main(String[] args) {
		// refer to
		// http://stackoverflow.com/questions/7469643/how-to-sort-alphabetically-while-ignoring-case-sensitive
		List l = new ArrayList();
		l.add("a");
		l.add("a");
		l.add("c");
		l.add("aa");
		l.add("c");
		l.add("aba");
		l.add("abba");
		l.add("aa");
		l.add("c");
		l.add("dba");
		l.add("dba");
		l.add("da");
		l.add("dbbba");
		l.add("dbaa");
		l.add("edbae");
		Collections.shuffle(l);
		System.out.println("l after shuffle:");
		for (Object e : l) {
			System.out.println(e.toString());
		}
		// !Collections.sort(l, new Object() implements Comparator<Object> {
		// public int compare() {return -1;} });
		Collections.sort(l, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase());
			}
		});
		System.out.println("l after sort:");
		for (Object e : l) {
			System.out.println(e.toString());
		}
	}
	
	/*Groovy equivalence
	 * 
    @Test(groups = ["feature"])
    def void sortListIgnoreCase () {
        //def l=l==null?[]:l
        def l = []
        l.add("a");
        l.add("a");
        l.add("c");
        l.add("aa");
        l.add("c");
        l.add("aba");
        l.add("abba");
        l.add("aa");
        l.add("c");
        l.add("dba");
        l.add("dba");
        l.add("da");
        l.add("dbbba");
        l.add("dbaa");
        l.add("edbae");
        Collections.shuffle(l);
        println "l after shuffle:"
        for (Object e : l) {
            println e.toString()
        }
        Collections.shuffle(l);
        Collections.sort(l,{a,b-> a.toString().toLowerCase().compareTo(b.toString().toLowerCase())} )
        println "l after sort:"
        for (Object e : l) {
            println e.toString()
        }
        println "Period"
    }

	 */

}
