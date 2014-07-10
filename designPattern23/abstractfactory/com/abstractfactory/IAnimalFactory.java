package com.abstractfactory;

import com.abstractproduct.ICat;
import com.abstractproduct.IDog;

public interface IAnimalFactory {

	ICat createCat();
	IDog createDog();
	
}
