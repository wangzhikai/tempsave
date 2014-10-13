package tea.looca;
import java.io.File;


public class GetUserHomeFolder {

	public static void main(String[] args) {
		 String userFolderPath = new File(System.getProperty("user.home")).getAbsolutePath();
		 System.out.println(userFolderPath);
		 System.out.println("C:\\Users\\ie11three");
		 
	}

}
//return 'C:\Users\ie11three' in Windows e.g. return '/Users/zwang' in Linux e.g.
//C:\Users\ie11three
//In Linux 
///Users/zwang