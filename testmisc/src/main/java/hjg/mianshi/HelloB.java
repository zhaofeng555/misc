package hjg.mianshi;

/**
 * 对象的初始化顺序：
 * （1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；
 * （2）当static语句执行完之后,再执行main方法；
 * （3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）。
 */
class HelloA {
	public HelloA() {
		System.out.println("HelloA");
	}

	{
		System.out.println("I'm A class");
	}
	static {
		System.out.println("static A");
	}
}

public class HelloB extends HelloA {
	public HelloB() {
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm B class");
	}
	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {
		new HelloB();
	}
}