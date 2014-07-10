package com.adapter;

import com.adaptee.Adaptee;
import com.target.Target;

public class Adapter implements Target {

	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}
	
	@Override
	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}

	@Override
	public void adpterMethod() {
		System.out.println("Adapter method !");
	}

}
