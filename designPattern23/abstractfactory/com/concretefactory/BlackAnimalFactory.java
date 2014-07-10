package com.concretefactory;

import com.abstractfactory.IAnimalFactory;
import com.abstractproduct.ICat;
import com.abstractproduct.IDog;
import com.concreteproduct.BlackCat;
import com.concreteproduct.BlackDog;

public class BlackAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new BlackCat();
	}

	@Override
	public IDog createDog() {
		return new BlackDog();
	}

}
