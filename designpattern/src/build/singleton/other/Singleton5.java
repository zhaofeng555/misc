package build.singleton.other;

//lazy  initialization holder class
public class Singleton5 {

	private static class SingletonHolder{
		public static MySingleton instance = new MySingleton();
	}
	
	public static MySingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}

//临时类
class MySingleton{
	
}
