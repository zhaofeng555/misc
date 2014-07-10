package com.concretefactory;

import com.abstractfactory.IAnimalFactory;
import com.abstractproduct.ICat;
import com.abstractproduct.IDog;
import com.concreteproduct.WhiteCat;
import com.concreteproduct.WhiteDog;

public class WhiteAnimalFactory implements IAnimalFactory {

	@Override
	public ICat createCat() {
		return new WhiteCat();
	}

	@Override
	public IDog createDog() {
		return new WhiteDog();
	}

}
