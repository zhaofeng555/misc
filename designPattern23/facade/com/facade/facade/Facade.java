package com.facade.facade;

import com.facade.subsystemclasses.ServiceA;
import com.facade.subsystemclasses.ServiceAImpl;
import com.facade.subsystemclasses.ServiceB;
import com.facade.subsystemclasses.ServiceBImpl;
import com.facade.subsystemclasses.ServiceC;
import com.facade.subsystemclasses.ServiceCImpl;

public class Facade {
	ServiceA sa ;
	ServiceB sb;
	ServiceC sc;
	
	public Facade(){
		sa=new ServiceAImpl();
		sb=new ServiceBImpl();
		sc=new ServiceCImpl();
	}
	
	public void methodA(){
		sa.methodA();
		sb.methodB();
	}
	
	public void methodB(){
		sb.methodB();
		sc.methodC();
	}
	
	public void methodC(){
		sc.methodC();
		sa.methodA();
	}
	
}
