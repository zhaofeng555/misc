package com.factorymethod.test;

import com.concretecreator.StudentWorkFactory;
import com.concretecreator.TeacherWorkFactory;
import com.creator.IWorkFactory;

public class FactoryMethodTest {

	public static void main(String[] args) {
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();
		
		IWorkFactory teacherWorkFactory=new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();
	}

}
