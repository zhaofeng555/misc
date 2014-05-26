package action.templatemethod.abstractclass;

public abstract class Template {

	public abstract void print(Object obj);
	
	public void update(){
		System.out.println("开始打印……");
		for (int i = 0; i < 10; i++) {
			print(i);
		}
	}
	
}
