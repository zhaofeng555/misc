package com.facade.test;

import com.facade.facade.Facade;
import com.facade.subsystemclasses.ServiceA;
import com.facade.subsystemclasses.ServiceAImpl;
import com.facade.subsystemclasses.ServiceB;
import com.facade.subsystemclasses.ServiceBImpl;

public class FacadeTest {

	public static void main(String[] args) {
		ServiceA sa = new ServiceAImpl();
		ServiceB sb = new ServiceBImpl();
		
		sa.methodA();
		sb.methodB();
		
		System.out.println("============");
		
		//facade
		Facade facade = new Facade();
		facade.methodA();
		facade.methodB();
	}
}
