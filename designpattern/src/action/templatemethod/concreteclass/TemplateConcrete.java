package action.templatemethod.concreteclass;

import action.templatemethod.abstractclass.Template;

public class TemplateConcrete extends Template {

	@Override
	public void print(Object obj) {
		System.out.println("这是子类实现……" + obj);
	}

}
