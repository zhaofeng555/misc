package com.bridge.concreteimplementor;

import com.bridge.abstraction.Person;
import com.bridge.implementor.Clothing;

public class Jacket extends Clothing {

	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType()+" 穿马甲 ！");
	}

}
