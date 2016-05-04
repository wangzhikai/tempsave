package tea.looca;
/**
 * @author Zhikai Wang/www.heteroclinic.net
Given third party license acknowledged and this header kept or quoted, you can utilize this program at will.
*/

import java.util.LinkedList;
import java.util.List;

public class CountConsective {

	   public static void main(String[] args) {
	        // TODO Auto-generated method stub

	        final String data = "aabbaadddc";
	        
	        List<String> chars = new LinkedList<String> ();
	        List<Integer> counts = new LinkedList<Integer> ();
	        
	        String  prev = "-1";    
	        int segs = 0;    
	        int currentCount = 0;
	        for (int i = 0; i< data.length(); i++ ) {
	            int currentChar = data.charAt(i);
	            if (!( Character.toString(data.charAt(i)) ).equals(prev)) {
	                chars.add(""+Character.toString(data.charAt(i)));
	                segs++;
	                currentCount = 1;
	                 counts.add(currentCount);
	            } else {
	              int temp = counts.get(segs-1) +1;
	              counts.set(segs-1,temp);
	            }
	            prev = Character.toString(data.charAt(i));
	        
	        }
	        
	        //OUTPUT
	        for (int i = 0; i< chars.size(); i++ ) {
	            System.out.print(""+chars .get (i) +counts.get(i));
	        }
	        
	        
	    }
}
