package com.concretecreator;

import com.concreteproduct.TeacherWork;
import com.creator.IWorkFactory;
import com.product.Work;

public class TeacherWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new TeacherWork();
	}

}
