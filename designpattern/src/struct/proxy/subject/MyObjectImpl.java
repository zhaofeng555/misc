package struct.proxy.subject;

public class MyObjectImpl implements MyObject {

	@Override
	public void action() {
		System.out.println("===============");
		System.out.println("===============");

		System.out.println("这个是被代理的类");
		
		System.out.println("===============");
		System.out.println("===============");

	}

}
