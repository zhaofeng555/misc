package hjg.json;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonMapExample {
	public static void main(String[] args) {

		String json = "{\"name\":\"hjg\", \"age\":\"29\"}";
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			// convert JSON string to Map
			map = mapper.readValue(json, new TypeReference<HashMap<String, String>>() {
				
			});

			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
