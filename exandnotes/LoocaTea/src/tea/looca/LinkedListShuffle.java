package tea.looca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListShuffle {
	public static void printQueue(Queue<String> queue) {
		List<String> l = new ArrayList <String>();
		l.addAll( queue);
		for (Object e:l) {
			System.out.print(e.toString()+" ");
		}
		System.out.println();
	}
	
	public static void putFirstToLast(Queue<String> queue) {
		String first = queue.poll();
		if (null != first) {
			queue.add(first);
		}
	}

	public static void main(String[] args) {
		
		LinkedList<String> ll = new LinkedList<String> ();
		for(int i =1; i<=3; i++) {
			ll.add(""+i);
		}
		printQueue(ll);
		 Collections.shuffle(ll);
		 printQueue(ll);

	
		
	}
}
