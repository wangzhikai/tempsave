package tea.looca;

public class JavaIntegerInBinaryFormat {
	

	public static void main(String[] args) {
		{
			System.out.println("===Compute ABS of negative 32-bit signed integer===");
			for (int i = -1, j= 0; j < 8; i--,j++) {
				//System.out.println(String.format("%32s", Integer.toBinaryString(i)));
				System.out.println(i);
				System.out.println(PaddingStrings.padAString(Integer.toBinaryString(i), '0', -32));
				int tmp = i;
				
				//System.out.println(PaddingStrings.padAString(Integer.toBinaryString(~tmp), '0', -32));
				//an wei qu fan zai jia yi
				System.out.println(~tmp + 1);
				System.out.println(PaddingStrings.padAString(Integer.toBinaryString(~tmp + 1), '0', -32));
				
				int tmp2 = (~tmp+1);
				System.out.println(~tmp2+1);
				System.out.println(PaddingStrings.padAString(Integer.toBinaryString(~tmp2+1), '0', -32));
				
				System.out.println();
				
				
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
