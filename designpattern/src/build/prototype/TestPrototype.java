package build.prototype;

import build.prototype.concreteprototype.ConcretePrototype;

public class TestPrototype {

	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("prototype");
		Prototype pro2 = (Prototype)pro.clone();
		
		System.out.println(pro.getName());
		System.out.println(pro2.getName());
		
	}

}
