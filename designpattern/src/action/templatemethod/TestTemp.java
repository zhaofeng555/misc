package action.templatemethod;

import action.templatemethod.abstractclass.Template;
import action.templatemethod.concreteclass.TemplateConcrete;

public class TestTemp {

	public static void main(String[] args) {
		Template tmp = new TemplateConcrete();
		tmp.update();
	}
}
