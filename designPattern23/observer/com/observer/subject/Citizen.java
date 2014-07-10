package com.observer.subject;

import java.util.ArrayList;
import java.util.List;

import com.observer.observer.Policeman;

public abstract class Citizen {

	public List pols;
	public String help = "normal";

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public abstract void sendMessage(String help);

	public void setPolicemen() {
		this.pols = new ArrayList();
	}

	public void register(Policeman pol) {
		this.pols.add(pol);
	}

	public void unRegister(Policeman pol) {
		this.pols.remove(pol);
	}

}
