package com.command.command;

import com.command.receiver.Receiver;

public abstract class Command {
	
	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver=receiver;
	}
	
	public abstract void execute();

}
