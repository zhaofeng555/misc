package com.observer.concretesubject;

import com.observer.observer.Policeman;
import com.observer.subject.Citizen;

public class TianHeCitizen extends Citizen {

	public TianHeCitizen(Policeman pol){
		setPolicemen();
		register(pol);
		register(pol);
	}
	
	@Override
	public void sendMessage(String help) {
		setHelp(help);
		for (int i = 0; i < pols.size(); i++) {
			Policeman pol = (Policeman)pols.get(i);
			pol.action(this);
		}
	}

}
