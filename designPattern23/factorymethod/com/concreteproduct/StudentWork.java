package com.concreteproduct;

import com.product.Work;

public class StudentWork implements Work {

	@Override
	public void doWork() {
		System.out.println("学生做作业！");
	}

}
