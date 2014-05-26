package action.command.command;

import action.command.receiver.Receiver;



public abstract class Command {

	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver=receiver;
	}
	
	public abstract void execute();
}
