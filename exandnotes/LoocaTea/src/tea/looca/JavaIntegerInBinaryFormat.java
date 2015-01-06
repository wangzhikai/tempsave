package tea.looca;

public class JavaIntegerInBinaryFormat {
	

	public static void main(String[] args) {
		{
			System.out.println("======");
			for (int i = 0, j= 0; j < 8; i--,j++) {
				System.out
				.println(String.format("%32s", Integer.toBinaryString(i)));
			}

		}
		{
			System.out.println("======");

			System.out
					.println(String.format("%32s", Integer.toBinaryString(-1)));
			System.out.println(String.format("%32s",
					Integer.toBinaryString(Integer.MAX_VALUE)));
			System.out.println(String.format("%32s",
					Integer.toBinaryString(0x7fffffff)));
			System.out.println(Double.toHexString(-1.23));
			// 11111111111111111111111111111111
			// 1111111111111111111111111111111
			// 1111111111111111111111111111111
			// -0x1.3ae147ae147aep0
			for (int i = Integer.MAX_VALUE, j = 0; j < 8; j++) {
				int tmp = i;
				System.out.println(tmp);
				System.out.println(String.format("%32s",
						Integer.toBinaryString(tmp)));
				i++;

				System.out.println(0x7fffffff & tmp);
				System.out.println(String.format("%32s",
						Integer.toBinaryString(0x7fffffff & tmp)));
				System.out.println("------");

			}
		}

	}

}
