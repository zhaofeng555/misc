package com.command.test;

import com.command.command.Command;
import com.command.concretecommand.CommandImpl;
import com.command.invoker.Invoker;
import com.command.receiver.Receiver;

public class CommandTest {

	public static void main(String[] args) {
		Receiver rec = new Receiver();
		Command cmd = new CommandImpl(rec);
		Invoker i = new Invoker();
		i.setCommand(cmd);
		i.execute();
	}
}
