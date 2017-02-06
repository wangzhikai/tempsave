package tea.looca;

public class StairCase {
    static void StairCase(int n) {
    	String blank = "";

    	for (int i = 0; i < n ;i ++) {
    		blank += " ";
    	}
    	
    	for (int i = blank.length() - 1; i>=0 ;i--) {
    		StringBuilder myName = new StringBuilder(blank);
    		myName.setCharAt(i, '#');

    		System.out.println(myName);
    		blank = myName.toString();
    	}
    	

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StairCase(10);
	}
	
    static int sum(int[] numbers) {
    	int sum = 0;
    	for (int n : numbers) {
    		sum += n;
    	}
    	return sum;
    }

}
