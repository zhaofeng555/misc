package com.test;

import com.abstractfactory.IAnimalFactory;
import com.abstractproduct.ICat;
import com.abstractproduct.IDog;
import com.concretefactory.BlackAnimalFactory;
import com.concretefactory.WhiteAnimalFactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
		ICat blackCat = blackAnimalFactory.createCat();
		blackCat.eat();
		IDog blackDog = blackAnimalFactory.createDog();
		blackDog.eat();

		IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
		ICat whiteCat = whiteAnimalFactory.createCat();
		whiteCat.eat();
		IDog whiteDog = whiteAnimalFactory.createDog();
		whiteDog.eat();
	}

}
