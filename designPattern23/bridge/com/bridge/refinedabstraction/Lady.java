package com.bridge.refinedabstraction;

import com.bridge.abstraction.Person;
import com.bridge.implementor.Clothing;

public class Lady extends Person {

	public Lady(){
		setType("女人");
	}
	
	@Override
	public void dress() {
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}

}
