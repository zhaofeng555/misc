package com.composite.leaf;

import com.composite.component.Employer;

public class Programmer extends Employer {

	public Programmer(String name){
		setName(name);
		super.employers=null;
	}
	
	@Override
	public void add(Employer employer) {

	}

	@Override
	public void delete(Employer employer) {

	}

}
