package com.concretebuilder;

import com.builder.PersonBuilder;
import com.product.Man;
import com.product.Person;

public class ManBuilder implements PersonBuilder {

	Person person;

	public ManBuilder() {
		person = new Man();
	}

	@Override
	public void buildHead() {
		System.out.println("建造男人的头");
	}

	@Override
	public void buildBody() {
		System.out.println("建造男人的身体");

	}

	@Override
	public void buildFoot() {
		System.out.println("建造男人的脚");

	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
