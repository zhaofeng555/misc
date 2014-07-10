package com.concreteproduct;

import com.abstractproduct.IDog;

public class WhiteDog implements IDog {

	@Override
	public void eat() {
		System.out.println("the white dog is eating");
	}

}
