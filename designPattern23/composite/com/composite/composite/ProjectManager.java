package com.composite.composite;

import java.util.ArrayList;

import com.composite.component.Employer;

public class ProjectManager extends Employer {

	public ProjectManager(String name){
		setName(name);
		employers=new ArrayList();
	}
	
	@Override
	public void add(Employer employer) {
		employers.add(employer);
	}

	@Override
	public void delete(Employer employer) {
		employers.remove(employer);
	}

}
