package com.decorator.decorator;

import com.decorator.component.Person;

public abstract class Decorator implements Person {

	protected Person person;
	
	public void setPerson(Person person){
		this.person=person;
	}
	
	@Override
	public void eat() {
		person.eat();
	}

}
