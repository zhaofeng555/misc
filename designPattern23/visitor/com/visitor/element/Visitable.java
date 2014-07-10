package com.visitor.element;

import com.visitor.visitor.Visitor;

public interface Visitable {
	
	public void accept(Visitor visitor);

}
