package tea.looca;

import java.io.File;

public class ClassExecutionPathTest {

	public static void main(String[] args) {
		final File f = new File(ClassExecutionPathTest.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(f);
		// OUT PUT:
		///Users/zwang/Desktop/tempsave/exandnotes/LoocaTea/bin

	}

}
