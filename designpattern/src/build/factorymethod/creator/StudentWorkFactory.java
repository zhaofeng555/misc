package build.factorymethod.creator;

import build.factorymethod.product.StudentWork;
import build.factorymethod.product.Work;

public class StudentWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}
