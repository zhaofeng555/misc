package com.visitor.concretevisitor;

import java.util.Collection;
import java.util.Iterator;

import com.visitor.concreteelement.FloatElement;
import com.visitor.concreteelement.StringElement;
import com.visitor.element.Visitable;
import com.visitor.visitor.Visitor;

public class ConcreteVisitor implements Visitor {

	@Override
	public void visitString(StringElement stringE) {
		System.out.println(stringE.getSe());
	}

	@Override
	public void visitFloat(FloatElement floatE) {
		System.out.println(floatE.getFloatE());
	}

	@Override
	public void visitCollection(Collection collection) {
		Iterator it = collection.iterator();
		while(it.hasNext()){
			Object obj =it.next();
//			System.out.println(obj.toString());
			if(obj instanceof Visitable){
				((Visitable)obj).accept(this);
			}
		}
	}

}
