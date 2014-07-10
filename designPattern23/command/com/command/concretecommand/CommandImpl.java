package com.command.concretecommand;

import com.command.command.Command;
import com.command.receiver.Receiver;

public class CommandImpl extends Command {

	public CommandImpl(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.receive();
	}

}
