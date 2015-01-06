package tea.looca;

//Wiki:http://en.wikipedia.org/wiki/Greatest_common_divisor
//In mathematics, the greatest common divisor (gcd) of two or more integers, when at least one of them is not zero, is the largest positive integer that divides the numbers without a remainder. For example, the GCD of 8 and 12 is 4.
//
//http://en.wikipedia.org/wiki/Modular_arithmetic
//The residue of a modulo n is the smallest non-negative element in the congruence class of a.
//WatchOUT !! http://en.wikipedia.org/wiki/Modulo_operation
//When either a or n is negative, the naive definition breaks down and programming languages differ in how these values are defined.


public class FindGCD {
	public static int findGCDv2(int a, int b) {
		if (a < b)
			return findGCDv2(b, a);
		else {
			if (a % b == 0) {
				return b;
			} else {
				return findGCDv2(b, a % b);
			}
		}

	}
	public static int findGCD(int a, int b) {
		if (a < b)
			return findGCD(b, a);
		else {
			if (a % b == 0) {
				return b;
			} else {
				return findGCD(b, a % b);
			}
		}

	}

	public static void main(String[] args) {
		{
			//Remainder operator java
			System.out.println("======");
			System.out.println(882 % 756);
			System.out.println(882 % -756);
			System.out.println(-882 % 756);
			System.out.println(-882 % -756);
//			126
//			126
//			-126
//			-126
			System.out.println("======");
			System.out.println(-756 % 882 );
			System.out.println(-756 % -882 );
			System.out.println(756 % 882 );
			System.out.println(756 % -882 );
//			-756
//			-756
//			756
//			756

		}
		
		{
			System.out.println("======");
			System.out.println(findGCD(882, 756));
//			System.out.println(findGCD(882, -756));
//			System.out.println(findGCD(-882, 756));
//			System.out.println(findGCD(756, 756));
//			System.out.println(findGCD(756, 882));
//			System.out.println(findGCD(756, -756));
//			System.out.println(findGCD(-882, 0));
			// 126
			// Exception in thread "main" java.lang.StackOverflowError
			// at tea.looca.FindGCD.findGCD(FindGCD.java:5)
			// at tea.looca.FindGCD.findGCD(FindGCD.java:6)
			// at tea.looca.FindGCD.findGCD(FindGCD.java:11)
			// at tea.looca.FindGCD.findGCD(FindGCD.java:6)
		}

	}

}
