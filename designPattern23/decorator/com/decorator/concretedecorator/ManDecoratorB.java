package com.decorator.concretedecorator;

import com.decorator.decorator.Decorator;

public class ManDecoratorB extends Decorator {

	@Override
	public void eat() {
		super.eat();
		System.out.println(" =================== ");
		System.out.println("ManDecoratorB 类");
	}
	
}
