package struct.proxy;

import struct.proxy.proxy.ProxyObject;
import struct.proxy.subject.MyObject;

public class TestProxy {

	public static void main(String[] args) {
		MyObject obj = new ProxyObject();
		obj.action();
	}
	
}
