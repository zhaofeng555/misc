package com.director;

import com.builder.PersonBuilder;
import com.product.Person;

public class PersonDirector {

	public Person constrctPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
	
}
