package tea.looca;

public class JavaNanoTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTimeNano = System.nanoTime();    
		System.out.println (startTimeNano);
		startTimeNano = System.nanoTime();    
		System.out.println (startTimeNano);
		long startTimeMilli = System.currentTimeMillis();
		System.out.println (startTimeMilli);
		startTimeNano =  System.currentTimeMillis();
		System.out.println (startTimeMilli);

	}
//	1420843139269347000
//	1420843139269504000
//	1420843139269
//	1420843139269

}
