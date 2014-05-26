package action.observer.subject;

import java.util.ArrayList;
import java.util.List;

import action.observer.observer.Policeman;

public abstract class Citizen {

	List<Policeman> pols;
	
	String help="normal";

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}
	
	public abstract void setMessage(String help);
	
	public void setPolicemen(){
		this.pols=new ArrayList<Policeman>();
	}
	
	public void register(Policeman pol){
		this.pols.add(pol);
	}
	
	public void unRegister(Policeman pol){
		this.pols.remove(pol);
	}
	
}
