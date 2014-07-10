package com.decorator.test;

import com.decorator.concretecomponent.Man;
import com.decorator.concretedecorator.ManDecoratorA;
import com.decorator.concretedecorator.ManDecoratorB;

public class DecoratorTest {

	public static void main(String[] args) {
		Man man = new Man();
		ManDecoratorA md1 = new ManDecoratorA();
		ManDecoratorB md2 = new ManDecoratorB();
		
		md1.setPerson(man);
		md2.setPerson(md1);
		System.out.println("--->");
		md2.eat();
		System.out.println("<---");
		
	}

}
