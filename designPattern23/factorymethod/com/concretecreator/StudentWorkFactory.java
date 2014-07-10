package com.concretecreator;

import com.concreteproduct.StudentWork;
import com.creator.IWorkFactory;
import com.product.Work;

public class StudentWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}
