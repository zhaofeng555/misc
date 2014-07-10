package com.observer.test;

import com.observer.concreteobserver.HuangPuPoliceman;
import com.observer.concreteobserver.TianHePoliceman;
import com.observer.concretesubject.HuangPuCitizen;
import com.observer.concretesubject.TianHeCitizen;
import com.observer.observer.Policeman;
import com.observer.subject.Citizen;

public class ObserverTest {

	public static void main(String[] args) {
		Policeman thPol = new TianHePoliceman();
		Policeman hpPol = new HuangPuPoliceman();
		
		Citizen citizen = new HuangPuCitizen(hpPol);
		citizen.sendMessage("unnormal");
		citizen.sendMessage("normal");
		
		System.out.println("==============");
		
		citizen = new TianHeCitizen(thPol);
		citizen.sendMessage("normal");
		citizen.sendMessage("unnormal");
		
	}

}
