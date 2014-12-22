package tea.looca;

//http://stackoverflow.com/questions/886955/breaking-out-of-nested-loops-in-java
public class BreakMultipleLoops {

	public static void main(String[] args) {
		outerloop: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i * j > 6) {
					System.out.println("Breaking");
					break outerloop;
				}
				System.out.println(i + " " + j);
			}
		}
		System.out.println("Done");
		
		{
			String caseName = "case 2";
			System.out.println(caseName);
			shell1: for (int i = 0; i < 5; i++) {
				shell2: for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (k == 3)
							break shell1;
						System.out.println(i + " " + j + " "+k);
					}
				}
			}
			System.out.println(caseName + " done");
		}
		{
			String caseName = "case 3";
			System.out.println(caseName);
			shell1: for (int i = 0; i < 5; i++) {
				shell2: for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (k == 4)
							break shell2;
						System.out.println(i + " " + j + " "+k);
					}
				}
			}
			System.out.println(caseName + " done");
		}

	}

}
/* Groovy
   @Test(groups = ["feature"])
    def void testBreakMultipleLoops() {
        Runnable run = {
            outerloop: for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i * j > 6) {
                        System.out.println("Breaking");
                        break outerloop;
                    }
                    System.out.println(i + " " + j);
                }
            }
            System.out.println("Done");
        }
        run.run()


        run = {
            String caseName = "case 2";
            System.out.println(caseName);
            shell1: for (int i = 0; i < 5; i++) {
                shell2: for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (k == 3)
                            break shell1;
                        System.out.println(i + " " + j + " "+k);
                    }
                }
            }
            System.out.println(caseName + " done");
        }
        run.run()

        run =        {
                    String caseName = "case 3";
                    System.out.println(caseName);
                    shell1: for (int i = 0; i < 5; i++) {
                        shell2: for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 5; k++) {
                                if (k == 4)
                                    break shell2;
                                System.out.println(i + " " + j + " "+k);
                            }
                        }
                    }
                    System.out.println(caseName + " done");
                }
        run.run()

    }

 */
