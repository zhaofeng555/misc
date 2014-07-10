package com.observer.concreteobserver;

import com.observer.observer.Policeman;
import com.observer.subject.Citizen;

public class TianHePoliceman implements Policeman {

	@Override
	public void action(Citizen ci) {
		String help = ci.getHelp();
		if("normal".equals(help)){
			System.out.println("一切正常，不用出动！");
		}
		if("unnormal".equals(help)){
			System.out.println("有犯罪行为，天河警察出动！");
		}
	}

}
