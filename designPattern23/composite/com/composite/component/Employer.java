package com.composite.component;

import java.util.List;

public abstract class Employer {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void add(Employer employer);

	public abstract void delete(Employer employer);

	public List employers;

	public void printInfo() {
		System.out.println(name);
	}

	public List getEmployers() {
		return this.employers;
	}

}
