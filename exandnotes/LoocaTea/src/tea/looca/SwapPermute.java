package tea.looca;
/**
 * @author Zhikai Wang/www.heteroclinic.net
 * You can utilize this program at will.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwapPermute {
	
	public static void permute(List<String> list, int i) {
		if (i>=list.size()-1) {
			System.out.println(list);
			return;
		}
		for (int c = i; c<list.size(); c++) {
			Collections.swap(list, c, i);
			permute(list,i+1);
			Collections.swap(list, c, i);
		}
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("E");
		list.add("I");
		list.add("O");
		list.add("U");
		
		permute ( list, 0);
		
	}

}
/*
[A, E, I, O, U]
[A, E, I, U, O]
[A, E, O, I, U]
[A, E, O, U, I]
[A, E, U, O, I]
[A, E, U, I, O]
[A, I, E, O, U]
[A, I, E, U, O]
[A, I, O, E, U]
[A, I, O, U, E]
[A, I, U, O, E]
[A, I, U, E, O]
[A, O, I, E, U]
[A, O, I, U, E]
[A, O, E, I, U]
[A, O, E, U, I]
[A, O, U, E, I]
[A, O, U, I, E]
[A, U, I, O, E]
[A, U, I, E, O]
[A, U, O, I, E]
[A, U, O, E, I]
[A, U, E, O, I]
[A, U, E, I, O]
[E, A, I, O, U]
[E, A, I, U, O]
[E, A, O, I, U]
[E, A, O, U, I]
[E, A, U, O, I]
[E, A, U, I, O]
[E, I, A, O, U]
[E, I, A, U, O]
[E, I, O, A, U]
[E, I, O, U, A]
[E, I, U, O, A]
[E, I, U, A, O]
[E, O, I, A, U]
[E, O, I, U, A]
[E, O, A, I, U]
[E, O, A, U, I]
[E, O, U, A, I]
[E, O, U, I, A]
[E, U, I, O, A]
[E, U, I, A, O]
[E, U, O, I, A]
[E, U, O, A, I]
[E, U, A, O, I]
[E, U, A, I, O]
[I, E, A, O, U]
[I, E, A, U, O]
[I, E, O, A, U]
[I, E, O, U, A]
[I, E, U, O, A]
[I, E, U, A, O]
[I, A, E, O, U]
[I, A, E, U, O]
[I, A, O, E, U]
[I, A, O, U, E]
[I, A, U, O, E]
[I, A, U, E, O]
[I, O, A, E, U]
[I, O, A, U, E]
[I, O, E, A, U]
[I, O, E, U, A]
[I, O, U, E, A]
[I, O, U, A, E]
[I, U, A, O, E]
[I, U, A, E, O]
[I, U, O, A, E]
[I, U, O, E, A]
[I, U, E, O, A]
[I, U, E, A, O]
[O, E, I, A, U]
[O, E, I, U, A]
[O, E, A, I, U]
[O, E, A, U, I]
[O, E, U, A, I]
[O, E, U, I, A]
[O, I, E, A, U]
[O, I, E, U, A]
[O, I, A, E, U]
[O, I, A, U, E]
[O, I, U, A, E]
[O, I, U, E, A]
[O, A, I, E, U]
[O, A, I, U, E]
[O, A, E, I, U]
[O, A, E, U, I]
[O, A, U, E, I]
[O, A, U, I, E]
[O, U, I, A, E]
[O, U, I, E, A]
[O, U, A, I, E]
[O, U, A, E, I]
[O, U, E, A, I]
[O, U, E, I, A]
[U, E, I, O, A]
[U, E, I, A, O]
[U, E, O, I, A]
[U, E, O, A, I]
[U, E, A, O, I]
[U, E, A, I, O]
[U, I, E, O, A]
[U, I, E, A, O]
[U, I, O, E, A]
[U, I, O, A, E]
[U, I, A, O, E]
[U, I, A, E, O]
[U, O, I, E, A]
[U, O, I, A, E]
[U, O, E, I, A]
[U, O, E, A, I]
[U, O, A, E, I]
[U, O, A, I, E]
[U, A, I, O, E]
[U, A, I, E, O]
[U, A, O, I, E]
[U, A, O, E, I]
[U, A, E, O, I]
[U, A, E, I, O]

 */