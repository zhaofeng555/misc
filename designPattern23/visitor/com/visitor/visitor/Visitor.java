package com.visitor.visitor;

import java.util.Collection;

import com.visitor.concreteelement.FloatElement;
import com.visitor.concreteelement.StringElement;

public interface Visitor {

	void visitString(StringElement stringE);
	void visitFloat(FloatElement floatE);
	void visitCollection(Collection collection);
}
