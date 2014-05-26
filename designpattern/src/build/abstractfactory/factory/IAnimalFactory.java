package build.abstractfactory.factory;

import build.abstractfactory.product.ICat;
import build.abstractfactory.product.IDog;

public interface IAnimalFactory {

	ICat createCat();
	IDog createDog();
	
}
