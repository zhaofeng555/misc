package com.decorator.concretedecorator;

import com.decorator.decorator.Decorator;

public class ManDecoratorA extends Decorator {

	@Override
	public void eat() {
		super.eat();
		reEat();
		System.out.println("ManDecoratorA 类");
	}
	
	public void reEat() {
		System.out.println("再吃一顿");
	}
	
}
