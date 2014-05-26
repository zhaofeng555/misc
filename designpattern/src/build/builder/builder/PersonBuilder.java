package build.builder.builder;

import build.builder.product.Person;

public interface PersonBuilder {

	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}
