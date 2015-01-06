package tea.looca;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TODOTestregex {

	public static void main(String[] args) {
		
		//http://docs.oracle.com/javase/tutorial/essential/regex/char_classes.html
		
//      //Expected :/ds/projects/77131214c0264f82a98bcdd93ac8e5bf/widgets/5ad49711d7ce4e40b0c87facd5d4bafc:Previous
//      //Actual   :/ds/projects/77131214c0264f82a98bcdd93ac8e5bf/widgets/566e7ea5c2464d688606aa97bb8cc262:Previous
//      String pattern1 = "\\/projects\\/[0-9a-zA-Z]+32";
      String expVerbose = "/ds/projects/77131214c0264f82a98bcdd93ac8e5bf/widgets/5ad49711d7ce4e40b0c87facd5d4bafc:Previous";
      String actVerbose = "/ds/projects/77131214c0264f82a98bcdd93ac8e5bf/widgets/566e7ea5c2464d688606aa97bb8cc262:Previous";
      //TODO Strip off the uuids
      String uuid1 = "77131214c0264f82a98bcdd93ac8e5bf";
      System.out.println("uuid1.leng = "+uuid1.length());
      Pattern pUid = Pattern.compile("[0-9a-zA-Z]{32}");
      Matcher mUid = pUid.matcher(expVerbose);
      while (mUid.find()) {
          System.out.println(""
                  +  mUid.group() +" \t "
                  +  mUid.start()+" \t "
                  ) ;   	  
      }
      String pattern1 = "\\/projects\\/[0-9a-zA-Z]{32}";
      String pattern2 = "widgets\\/[0-9a-zA-Z]{32}";
      //String expCompact = expVerbose.replaceAll(pattern1, "/projects/");
      //System.out.println(expCompact);
      // ?? replaceAll, replace not work.
      String expCompact = expVerbose.replaceAll(pattern1, "/projects/");
      expCompact = expCompact.replaceAll(pattern2, "widgets/");
      
      System.out.println("expCompact = "+expCompact);
      
      String actCompact = actVerbose.replaceAll(pattern1, "/projects/");
      actCompact = actCompact.replaceAll(pattern2, "widgets/");
      //System.out.println(actCompact);

      System.out.println("actCompact = "+actCompact);

      
//      		uuid1.leng = 32
//    		  77131214c0264f82a98bcdd93ac8e5bf 	 13 	 
//    		  5ad49711d7ce4e40b0c87facd5d4bafc 	 54 	 
//    		  /ds/projects//widgets/5ad49711d7ce4e40b0c87facd5d4bafc:Previous      
      
		System.out.println("======");
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
//         64 	 0 	 
//         2 	 3 	 
//         23 	 5 	 
//         1 	 8          
         System.out.println("======");
         System.out.println("000".replace("0", ""));
         System.out.println("000sfe".replaceAll("^[0]+", ""));
         System.out.println("000sf00e0".replaceAll("^[0]+", ""));
	
         System.out.println("".replaceAll("[,]+$", ""));
         System.out.println(",".replaceAll("[,]+$", ""));
         System.out.println(",,".replaceAll("[,]+$", ""));
         System.out.println("2,2,2,,".replaceAll("[,]+$", ""));
         System.out.println("2,2,2,".replaceAll("[,]+$", ""));
         
         System.out.println(Integer.MAX_VALUE);
//
//sfe
//sf00e0
//
//
//
//2,2,2
//2,2,2
//2147483647         
         System.out.println("======");

         System.out.println("======");         
 		String something = "13fsfs fsfesfe fsfes";
 		for (String s : something.split("\\s+") ) {
 			System.out.println(s ); //[0,3)
 		}
 		for (int i = 0; i < 100 ; i++) {
 			System.out.println( ((int) (Math.random()*3)) + 1 ); //[0,3)
 		}        
// 		13fsfs
// 		fsfesfe
// 		fsfes
// 		1
// 		2
// 		2
// 		1
// 		1
// 		2
// 		2
// 		2
// 		2
// 		3
// 		2
// 		2
// 		3
// 		3
// 		3
// 		2
// 		3
// 		2
// 		2
// 		1
// 		1
// 		1
// 		3
// 		1
// 		3
// 		3
// 		3
// 		3
// 		2
// 		1
// 		3
// 		2
// 		3
// 		3
// 		2
// 		2
// 		2
// 		1
// 		2
// 		1
// 		1
// 		2
// 		1
// 		1
// 		1
// 		2
// 		1
// 		2
// 		1
// 		1
// 		2
// 		2
// 		1
// 		1
// 		1
// 		3
// 		2
// 		2
// 		1
// 		2
// 		3
// 		2
// 		3
// 		3
// 		3
// 		1
// 		3
// 		1
// 		1
// 		1
// 		3
// 		3
// 		2
// 		1
// 		1
// 		3
// 		2
// 		2
// 		3
// 		3
// 		1
// 		2
// 		2
// 		3
// 		2
// 		2
// 		1
// 		3
// 		1
// 		1
// 		2
// 		2
// 		2
// 		2
// 		2
// 		1
// 		2
// 		1
// 		2
// 		3
	}
}
