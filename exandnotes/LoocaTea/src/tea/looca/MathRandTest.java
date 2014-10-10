package tea.looca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathRandTest {
	public static void doSomething (List<?> l) {
		 for (Object o: (l ==null ? new ArrayList<Object> () : l) )
			 ;
	}
	public static void doSomethingBad (List<?> l) {
		 for (Object o: l) 
			 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math.random();
		int size = 4;
		for (int i = 0; i< 30; i++)
			System.out.println((int)(Math.random()*(size)));
		Random r = new Random();
		
//		for (int i = 0; i < 30; i++)
//			System.out.println(r.nextInt(size));
		List<Object> l = null;
		//for (Object o:l ; l!=null;) {
			
		//}
		//for (Object o: (l ==null ? new ArrayList<Object> () : l))
			;

		 for (Object o: (l ==null ? new ArrayList<Object> () : l) )
			 ;
		 doSomething (null);
		 doSomething( new ArrayList<Object> ());

		 doSomethingBad (null);
		 doSomethingBad( new ArrayList<Object> ());
	}

}
