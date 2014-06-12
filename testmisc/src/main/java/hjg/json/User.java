package hjg.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int age = 29;
	private String name = "haojg";
	private List<String> messages = new ArrayList<String>();
	public User(){
		messages.add("hello");
	}
	
	// getter and setter methods
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", " + "messages=" + messages + "]";
	}
}
