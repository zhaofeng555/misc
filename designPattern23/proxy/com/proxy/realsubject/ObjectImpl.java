package com.proxy.realsubject;

import com.proxy.subject.MyObject;

public class ObjectImpl implements MyObject {

	@Override
	public void action() {
		System.out.println("===========");
		System.out.println("===========");
		System.out.println("这是被代理的类");
		System.out.println("===========");
		System.out.println("===========");
	}

}
