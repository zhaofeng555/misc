package action.command;

import action.command.command.Command;
import action.command.command.CommandImpl;
import action.command.command.Invoker;
import action.command.receiver.Receiver;

public class TestCommand {

	public static void main(String[] args) {
		Receiver rec = new Receiver();
		Command cmd = new CommandImpl(rec);
		Invoker i = new Invoker();
		i.setCommand(cmd);
		i.execute();

	}

}
