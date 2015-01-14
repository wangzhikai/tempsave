package tea.looca;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

// refer to  http://www.snakeyaml.org LoadExampleTest
//http://www.apache.org/licenses/LICENSE-2.0
public class SnakeYAMLTest {

	public static void main(String[] args) {
        InputStream input;
		try {
			input = new FileInputStream(new File("/Users/zwang/dcmlui/suite/irise-dod-service/src/main/resources/com/irise/ds/rest/action.yaml"));
	        Yaml yaml = new Yaml();
	        Object data = yaml.load(input);
	        //
	        data = yaml.load(new ByteArrayInputStream("test2".getBytes("UTF-8")));
	        System.out.println(data.toString());
	        input.close();

		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
