package build.abstractfactory.concreteproduct;

import build.abstractfactory.product.ICat;

public class WhiteCat implements ICat {

	@Override
	public void eat() {
		System.out.println("白猫再吃……");
	}

}
