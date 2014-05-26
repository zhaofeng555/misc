package build.abstractfactory.concretefactory;

import build.abstractfactory.concreteproduct.WhiteCat;
import build.abstractfactory.concreteproduct.WhiteDog;
import build.abstractfactory.factory.IAnimalFactory;
import build.abstractfactory.product.ICat;
import build.abstractfactory.product.IDog;

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
