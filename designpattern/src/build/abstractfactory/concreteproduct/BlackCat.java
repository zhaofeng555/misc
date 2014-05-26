package build.abstractfactory.concreteproduct;

import build.abstractfactory.product.ICat;

public class BlackCat implements ICat {

	@Override
	public void eat() {
		System.out.println("黑猫在吃……");
	}

}
