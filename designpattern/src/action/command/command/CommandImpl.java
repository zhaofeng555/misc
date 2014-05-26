package action.command.command;

import action.command.receiver.Receiver;

public class CommandImpl extends Command {

	public CommandImpl(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
			receiver.receive();
	}

}
