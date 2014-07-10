package com.concreteproduct;

import com.abstractproduct.ICat;

public class BlackCat implements ICat {

	@Override
	public void eat() {
		System.out.println("the black cat is eating");
	}

}
