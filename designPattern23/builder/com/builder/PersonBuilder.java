package com.builder;

import com.product.Person;

public interface PersonBuilder {
	void buildHead();

	void buildBody();

	void buildFoot();

	Person buildPerson();
	
}
