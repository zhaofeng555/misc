package build.factorymethod;

import build.factorymethod.creator.IWorkFactory;
import build.factorymethod.creator.StudentWorkFactory;
import build.factorymethod.creator.TeacherWorkFactory;
import build.factorymethod.product.Work;

public class TestFactoryMethod {

	public static void main(String[] args) {
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		Work studentWork = studentWorkFactory.getWork();
		studentWork.doWork();
		
		IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
		Work teacherWork=teacherWorkFactory.getWork();
		teacherWork.doWork();

	}

}
