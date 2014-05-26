package action.memento;

import action.memento.memento.Caretaker;
import action.memento.memento.Originator;

public class TestMemento {

	public static void main(String[] args) {
		Originator org = new Originator();
		org.setState("开会中");
		
		Caretaker ctk = new Caretaker();
		ctk.setMemento(org.createMemento());
		
		org.setState("睡觉啊");
		org.showState();
		
		org.setMemento(ctk.getMemento());
		org.showState();
		
		org.setState("吃饭中");
		org.showState();
	}
}