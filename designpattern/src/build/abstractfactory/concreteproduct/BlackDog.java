package build.abstractfactory.concreteproduct;

import build.abstractfactory.product.IDog;

public class BlackDog implements IDog {

	@Override
	public void eat() {
		System.out.println("黑狗在吃……");
	}

}
