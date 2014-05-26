package action.observer;

import action.observer.observer.HuangPuPoliceman;
import action.observer.observer.Policeman;
import action.observer.observer.TianHePoliceman;
import action.observer.subject.Citizen;
import action.observer.subject.HuangPuCitizen;
import action.observer.subject.TianHeCitizen;

public class TestObserver {
	public static void main(String[] args) {
		Policeman thPol = new TianHePoliceman();
		Policeman hpPol = new HuangPuPoliceman();
		
		
		Citizen citizen = new HuangPuCitizen(hpPol);
		citizen.setMessage("unnormal");
		citizen.setMessage("normal");
		
		System.out.println("=================");
		
		Citizen citizen2 = new TianHeCitizen(thPol);
		citizen2.setMessage("normal");
		citizen2.setMessage("unnormal");
		
	}
}
