package com.observer.concretesubject;

import com.observer.observer.Policeman;
import com.observer.subject.Citizen;

public class HuangPuCitizen extends Citizen {

	public HuangPuCitizen(Policeman pol){
		setPolicemen();
		register(pol);
	}
	
	@Override
	public void sendMessage(String help) {
		setHelp(help);
		for (int i = 0; i < pols.size(); i++) {
			Policeman pol = (Policeman)pols.get(i);
			
			//通知警察
			pol.action(this);
		}
	}

}
