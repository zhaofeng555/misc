package action.visitor.element;

import action.visitor.visitor.Visitor;

public interface Visitable {

	void accept(Visitor visitor);
	
}
