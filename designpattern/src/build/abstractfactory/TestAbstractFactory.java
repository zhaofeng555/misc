package build.abstractfactory;

import build.abstractfactory.concretefactory.BlackAnimalFactory;
import build.abstractfactory.concretefactory.WhiteAnimalFactory;
import build.abstractfactory.factory.IAnimalFactory;
import build.abstractfactory.product.ICat;
import build.abstractfactory.product.IDog;

public class TestAbstractFactory {

	public static void main(String[] args) {
		IAnimalFactory blackAnimalFactory=new BlackAnimalFactory();
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
