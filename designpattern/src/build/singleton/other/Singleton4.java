package build.singleton.other;

//双检锁
public class Singleton4 {

	private static Singleton4 uniqueInstance;

	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton4.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton4();
				}
			}
		}
		return uniqueInstance;
	}
}
