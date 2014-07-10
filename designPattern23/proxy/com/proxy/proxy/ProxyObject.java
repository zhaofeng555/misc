package com.proxy.proxy;

import com.proxy.realsubject.ObjectImpl;
import com.proxy.subject.MyObject;

public class ProxyObject implements MyObject {

	MyObject obj;
	
	public ProxyObject(){
		System.out.println("这是代理类");
		obj = new ObjectImpl();
	}
	
	@Override
	public void action() {
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结束");
	}
	

}
