package com.composite.leaf;

import com.composite.component.Employer;

public class ProjectAssistant extends Employer{

	public ProjectAssistant(String name) {
		setName(name);
		employers=null;
	}
	
	@Override
	public void add(Employer employer) {
		
	}

	@Override
	public void delete(Employer employer) {
		
	}

}
