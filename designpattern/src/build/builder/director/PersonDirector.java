package build.builder.director;

import build.builder.builder.PersonBuilder;
import build.builder.product.Person;

public class PersonDirector {

	public Person constructPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
	
}
