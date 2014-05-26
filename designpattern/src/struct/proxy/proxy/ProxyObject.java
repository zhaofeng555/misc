package struct.proxy.proxy;

import struct.proxy.subject.MyObject;
import struct.proxy.subject.MyObjectImpl;

public class ProxyObject implements MyObject {

	MyObject obj;
	
	public  ProxyObject(){
		System.out.println("这个是代理类");
		obj=new MyObjectImpl();
	}
	
	@Override
	public void action() {
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结果");
	}

}
