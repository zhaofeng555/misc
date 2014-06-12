package hjg.json;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

public class JacksonExample {
	public static void main(String[] args) {
		Obj2Json();
		System.out.println("========================");
		Json2Obj();
	}

	private static void Obj2Json() {
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		try {
			// convert user object to json string, and save to a file
			mapper.writeValue(new File("resource/user.json"), user);

			// display to console
			System.out.println(mapper.writeValueAsString(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Json2Obj() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// read from file, convert it to user class
			User user = mapper.readValue(new File("resource/user.json"), User.class);

			// display to console
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
