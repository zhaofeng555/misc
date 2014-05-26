package action.mediator;

import action.mediator.mediator.ConcreteMediator;
import action.mediator.mediator.Mediator;

public class TestMediator {

	public static void main(String[] args) {
		Mediator med = new ConcreteMediator();
		med.notice("boss");
		med.notice("client");
	}
}
