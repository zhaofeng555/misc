package com.proxy.test;

import com.proxy.proxy.ProxyObject;
import com.proxy.subject.MyObject;

public class ProxyTest {

	public static void main(String[] args) {
		MyObject obj = new ProxyObject();
		obj.action();
	}

}
