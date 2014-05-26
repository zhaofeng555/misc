package build.singleton;

public class Singleton {

	private static Singleton sing;
	
	private Singleton(){
	}
	
	public static Singleton getInstance(){
		if(sing==null){
			sing=new Singleton();
		}
		return sing;
	}
	
}
