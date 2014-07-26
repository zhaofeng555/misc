package hjg.json;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * @author hjg
 * 
 **/
public class JavaObjectToJson implements Serializable{

	private int data = 100;
	private String str = "hello";

	public static void test1(){
		JavaObjectToJson obj = new JavaObjectToJson();
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		System.out.println(json);
	}
	
	public static void test2(){
		String json = "{'data':101, 'str':'hello1'}";
		Gson gson = new Gson();
		JsonToJavaObject jobj = gson.fromJson(json, JsonToJavaObject.class);
		System.out.println(jobj);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Object --- > Json");
		test1();
		System.out.println("Json --- > Object");
		test2();
		
	}

}

class JsonToJavaObject {
	private int data;
	private String str;
	
	@Override
	public String toString() {
		return "data = "+data+" , str = "+str;
	}
}
