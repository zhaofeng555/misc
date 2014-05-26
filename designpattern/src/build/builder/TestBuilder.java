package build.builder;

import build.builder.concretebuilder.ManBuilder;
import build.builder.director.PersonDirector;
import build.builder.product.Person;

public class TestBuilder {

	public static void main(String[] args) {
		PersonDirector pd=new PersonDirector();
		Person person = pd.constructPerson(new ManBuilder());
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
	}

}
