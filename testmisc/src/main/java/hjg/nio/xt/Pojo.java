package hjg.nio.xt;

import java.util.List;

public class Pojo {

	private String name;
	private int age;
	private List<String> msg;
	
	public Pojo(String name, int age, List<String> msg) {
		super();
		this.name = name;
		this.age = age;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getMsg() {
		return msg;
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	
}
