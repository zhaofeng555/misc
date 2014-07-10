package com.mediator.concretemediator;

import com.mediator.colleagueclass.ColleagueA;
import com.mediator.colleagueclass.ColleagueB;
import com.mediator.mediator.Mediator;

public class ConcreteMediator extends Mediator {

	private ColleagueA ca;
	private ColleagueB cb;

	public ConcreteMediator() {
		ca = new ColleagueA();
		cb = new ColleagueB();
	}

	@Override
	public void notice(String content) {
		if(content.equals("boss")){
			ca.aciton();
		}
		if(content.equals("client")){
			cb.aciton();
		}
	}

}
