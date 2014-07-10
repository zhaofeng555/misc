package com.concreteproduct;

import com.abstractproduct.IDog;

public class BlackDog implements IDog {

	@Override
	public void eat() {
		System.out.println("the black dog is eating");
	}

}
