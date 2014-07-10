package com.memento.test;

import com.memento.caretaker.Caretaker;
import com.memento.originator.Originator;

public class MediatorTest {
	public static void main(String[] args) {
		Originator org = new Originator();
		org.setState("开会中");
		
		Caretaker ctk = new Caretaker();
		ctk.setMemento(org.createMemento());
		
		org.setState("睡觉中");
		org.showState();//
		System.out.println("----------------");
		org.setMemento(ctk.getMemento());
		org.showState();
	}
}
