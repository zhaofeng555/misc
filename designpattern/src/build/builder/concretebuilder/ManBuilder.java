package build.builder.concretebuilder;

import build.builder.builder.PersonBuilder;
import build.builder.product.Person;

public class ManBuilder implements PersonBuilder {

	Person person;
	
	public ManBuilder(){
		person = new Person();
	}
	
	@Override
	public void buildHead() {
		person.setHead("建造男人的头");
	}

	@Override
	public void buildBody() {
		person.setBody("建造男人的身体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("建造男人的脚");
	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
