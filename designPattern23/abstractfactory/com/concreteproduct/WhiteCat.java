package com.concreteproduct;

import com.abstractproduct.ICat;

public class WhiteCat implements ICat {

	@Override
	public void eat() {
		System.out.println("the white cat is eating ");
	}

}
