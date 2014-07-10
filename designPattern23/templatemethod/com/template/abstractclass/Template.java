package com.template.abstractclass;

public abstract class Template {

	public abstract void print();
	
	public void update(){
		
		System.out.println("开始打印");
		for (int i = 0; i < 3; i++) {
			print();
		}
	}
}
