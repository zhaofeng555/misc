package action.mediator.mediator;

import action.mediator.colleague.ColleagueA;
import action.mediator.colleague.ColleagueB;

public class ConcreteMediator extends Mediator {

	private ColleagueA ca;
	private ColleagueB cb;

	public ConcreteMediator(){
		ca = new ColleagueA();
		cb = new ColleagueB();
	}
	
	@Override
	public void notice(String content) {
		if(content.equals("boss")){
			ca.action();
		}
		if(content.equals("client")){
			cb.action();
		}
	}

	
}
