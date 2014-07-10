package com.prototypetest;

import com.concreteprototype.ConcretePrototype;
import com.prototype.Prototype;

public class PrototypeTest {

	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("prototype ... 1");
		Prototype pro2 = (Prototype)pro.clone();
		
		System.out.println(pro);
		System.out.println(pro2);
		
		System.out.println(pro.getName());
		System.out.println(pro2.getName());
		
	}

}
