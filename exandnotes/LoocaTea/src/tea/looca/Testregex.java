package tea.looca;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testregex {

	public static void main(String[] args) {
		
		String something = "13fsfs fsfesfe fsfes";
		for (String s : something.split("\\s+") ) {
			System.out.println(s ); //[0,3)
		}
		for (int i = 0; i < 100 ; i++) {
			System.out.println( ((int) (Math.random()*3)) + 1 ); //[0,3)
		}
		// TODO Auto-generated method stub
		String data ="64s2,23,1";
		Pattern p = Pattern.compile("[0-9]+");
		 Matcher m = p.matcher(data);
		 //boolean b = m.matches();
		 

         while (m.find()) {
             System.out.println(""
               +  m.group() +" \t "
               +  m.start()+" \t "
               ) ;
             
         }
         
         System.out.println("000".replace("0", ""));
         System.out.println("000sfe".replaceAll("^[0]+", ""));
         System.out.println("000sf00e0".replaceAll("^[0]+", ""));
	
         System.out.println("".replaceAll("[,]+$", ""));
         System.out.println(",".replaceAll("[,]+$", ""));
         System.out.println(",,".replaceAll("[,]+$", ""));
         System.out.println("2,2,2,,".replaceAll("[,]+$", ""));
         System.out.println("2,2,2,".replaceAll("[,]+$", ""));
         
         System.out.println(Integer.MAX_VALUE);

	}

}
