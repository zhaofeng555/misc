package struct.decorator.decorator;

import struct.decorator.componnet.Person;

public class Decorator implements Person {

	protected Person person;

	@Override
	public void eat() {
		person.eat();
	}
	
	public void setPerson(Person person){
		this.person=person;
	}

}
