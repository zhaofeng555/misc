package com.decorator.concretecomponent;

import com.decorator.component.Person;

public class Man implements Person {

	@Override
	public void eat() {
		System.out.println("男人在吃");
	}

}
