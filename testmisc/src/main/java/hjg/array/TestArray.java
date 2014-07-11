package hjg.array;

import java.util.Arrays;
import java.util.Comparator;

public class TestArray {

	public static void main(String[] args) {
		User us[] = new User[3];
		us[0] = new User(2, "hello2");
		us[1] = new User(1, "hello1");
		us[2] = new User(3, "hello2");
		Arrays.sort(us, new Comparator<User>() {
			public int compare(User o1, User o2) {
				return o1.id - o2.id;
			}
		});

		for (User u : us) {
			System.out.println(u);
		}
	}

}

class User {
	public int id;
	public String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
