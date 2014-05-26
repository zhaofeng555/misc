package build.abstractfactory.concreteproduct;

import build.abstractfactory.product.IDog;

public class WhiteDog implements IDog{

	@Override
	public void eat() {
		System.out.println("白狗再吃……");
	}

}
