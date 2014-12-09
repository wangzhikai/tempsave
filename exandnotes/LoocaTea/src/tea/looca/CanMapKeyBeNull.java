package tea.looca;

import java.util.LinkedHashMap;
import java.util.Map;

public class CanMapKeyBeNull {

	public static void main(String[] args) {
		Map <String, String> mss = new LinkedHashMap<String,String> ();
		mss.put(null,"cooldon");
		System.out.println(mss.get(null));

	}

}
