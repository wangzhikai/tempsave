package tea.looca;

import java.util.LinkedList;
import java.util.List;

//import java.util.Collection.metaClass.cartesianProduct;
public class TODOCartesianProductTest {
    public static List getListListCartesian (List list1, List list2) {
        List result = new LinkedList();
        int lastRowSize = -1;
        for (Object e1: list1) {
            for (Object e2: list2 ){
                Object currentRow = new LinkedList();
                // e1 instance of List else
                if (e1 instanceof List) {
                    for (Object e: (List)e1 ) {
                        ((List)currentRow).add(e);
                    }
                } else {
                	((List)currentRow).add(e1);
                }

                // e2 instance of List else
                if (e2 instanceof List) {
                    for (Object e: (List)e2 ) {
                    	((List)currentRow).add(e);
                    }
                } else {
                	((List)currentRow).add(e2);
                }

                if (lastRowSize != -1) {
                    //assertEquals(lastRowSize,((List)currentRow).size(),"Matrices dimensions not match.")
                	if (lastRowSize !=((List)currentRow).size())
                		throw new RuntimeException("Matrices dimensions not match.");
                }
                lastRowSize = ((List)currentRow).size();
                result.add(currentRow);
            }
        }
        return result;
    }

	public static void main(String[] args) {
		// experiments cases:
		
		//TODO 
		// Case I: list of literals X list of literals
		// Case II: list of literals X list of list
		// Case III: list of list X list of literals
		// Case IV: list of list X list of list

	}

}
