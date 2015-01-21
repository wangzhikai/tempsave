package tea.looca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DeduplicateIgnoreCase {

	public static void main(String[] args) {
		
		
		//Collections.binarySearch(list, key)
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
		
		Set x = new LinkedHashSet(l);
		for (Object o:x) {
			System.out.println(o.toString());
		}
		//Or
		System.out.println(x.toString());
//		a
//		c
//		aa
//		aba
//		abba
//		dba
//		da
//		dbbba
//		dbaa
//		edbae
//		[a, c, aa, aba, abba, dba, da, dbbba, dbaa, edbae]
		x = new TreeSet(l);
		for (Object o:x) {
			System.out.println(o.toString());
		}
		//Or
		System.out.println(x.toString());
		
		//System.out.println(Collections.list(x.).toString());
		

	}

}
/* Groovy deduplicate ignore case.
    static def dedupSortIgnoreCase (l) {
        l=l==null?[]:l
        l=sortListIgnoreCase(l)
        def x = new LinkedHashMap()

        for (def e:l) {
            x.put(e.toString().toLowerCase(),e)
        }

        l.clear()
        l.addAll(x.values())
        l
    }
    */
