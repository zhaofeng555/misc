package build.factorymethod.creator;

import build.factorymethod.product.TeacherWork;
import build.factorymethod.product.Work;

public class TeacherWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return  new TeacherWork();
	}

}
