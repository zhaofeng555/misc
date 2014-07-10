package com.bridge.refinedabstraction;

import com.bridge.abstraction.Person;
import com.bridge.implementor.Clothing;

public class Man extends Person {

	public Man(){
		setType("男人");
	}
	
	@Override
	public void dress() {
		Clothing clothing=getClothing();
		clothing.personDressCloth(this);
	}

}
