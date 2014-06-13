package hjg.xml;

public class XmlDTO {
	private String name;
	private String age;
	public XmlDTO(){}
	public XmlDTO(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "XmlDTO [name=" + name + ", age=" + age + "]";
	}
}
