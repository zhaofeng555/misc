package action.observer.subject;

import action.observer.observer.Policeman;

public class TianHeCitizen extends Citizen {

	public TianHeCitizen(Policeman pol){
		setPolicemen();
		register(pol);
	}
	
	@Override
	public void setMessage(String help) {
		setHelp(help);
		for (int i = 0; i < pols.size(); i++) {
			Policeman pol = pols.get(i);
			pol.action(this);
		}
	}
}
