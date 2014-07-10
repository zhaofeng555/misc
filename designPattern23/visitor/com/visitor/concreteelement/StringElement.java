package com.visitor.concreteelement;

import com.visitor.element.Visitable;
import com.visitor.visitor.Visitor;

public class StringElement implements Visitable {

	private String se;

	public StringElement(String se) {
		this.se = se;
	}

	public String getSe() {
		return this.se;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitString(this);
	}

}
