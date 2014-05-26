package build.singleton;

public class TestSingleton {

	public static void main(String[] args) {
		Singleton sing1 = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();
		
		System.out.println(sing1);
		System.out.println(sing2);
	}

}
