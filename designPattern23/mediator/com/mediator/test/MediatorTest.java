package com.mediator.test;

import com.mediator.concretemediator.ConcreteMediator;
import com.mediator.mediator.Mediator;

public class MediatorTest {

	public static void main(String[] args) {
		Mediator med = new ConcreteMediator();
		
		//老板来了
		med.notice("boss");
		
		//客户来了
		med.notice("client");
	}
	
}
