package tea.looca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TODOMexicanPlaza {

	public static void main(String[] args) {
		// Refer to: http://www.mkyong.com/java/java-properties-file-examples/
		// TODO A mall you can hang around
		
		String userFolderPath = new File(System.getProperty("user.home")).getAbsolutePath();
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream(userFolderPath+"/"+"mexican.food");
	 
			// load a properties file
			prop.load(input);
	 
			// get the property value and print it out
			System.out.println(prop.getProperty("taco"));
			System.out.println(prop.getProperty("tortilla"));
			System.out.println(prop.getProperty("chiapas"));
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
