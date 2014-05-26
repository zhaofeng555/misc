package build.abstractfactory.concretefactory;

import build.abstractfactory.concreteproduct.BlackCat;
import build.abstractfactory.concreteproduct.BlackDog;
import build.abstractfactory.factory.IAnimalFactory;
import build.abstractfactory.product.ICat;
import build.abstractfactory.product.IDog;

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
