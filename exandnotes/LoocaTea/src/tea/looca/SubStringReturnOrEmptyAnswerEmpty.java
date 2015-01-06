package tea.looca;

public class SubStringReturnOrEmptyAnswerEmpty {

	public static void main(String[] args) {

		String data = "abragealta";
		for (int i = data.length() -1 ; i>= 1; i--) {
			System.out.println(data.substring(i));
		}
		{
			for (int i = 0; i< data.length(); i++) {
				System.out.println(data.substring(i));
			}
//		abragealta
//		bragealta
//		ragealta
//		agealta
//		gealta
//		ealta
//		alta
//		lta
//		ta
//		a
//
		}
		{
			
		}
	}

}
