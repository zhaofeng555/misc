package action.visitor.visitor;

import java.util.Collection;
import java.util.Iterator;

import action.visitor.element.FloatElment;
import action.visitor.element.StringElement;
import action.visitor.element.Visitable;

public class ConcreteVisitor implements Visitor {

	@Override
	public void visitString(StringElement stringE) {
		System.out.println(stringE.getSe());
	}

	@Override
	public void visitFloat(FloatElment floatE) {
		System.out.println(floatE.getFe());
	}

	@Override
	public void visitCollection(Collection collection) {
		Iterator iterator= collection.iterator();
		while(iterator.hasNext()){
			Object o = iterator.next();
			if(o instanceof Visitable){
				((Visitable)o).accept(this);
			}
		}
	}

}
