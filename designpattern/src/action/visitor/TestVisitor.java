package action.visitor;

import java.util.ArrayList;
import java.util.List;

import action.visitor.element.FloatElment;
import action.visitor.element.StringElement;
import action.visitor.visitor.ConcreteVisitor;
import action.visitor.visitor.Visitor;

public class TestVisitor {

	public static void main(String[] args) {
		Visitor visitor = new ConcreteVisitor();
		StringElement se = new StringElement("abc");
		se.accept(visitor);
		visitor.visitString(se);
		
		FloatElment fe = new FloatElment(1.5F);
		fe.accept(visitor);
		visitor.visitFloat(fe);
		System.out.println("===========");
		
		List result = new ArrayList();
		result.add(new StringElement("bcd"));
		result.add(new StringElement("cde"));
		result.add(new StringElement("def"));
		
		result.add(new FloatElment(1.6F));
		result.add(new FloatElment(1.7F));
		result.add(new FloatElment(1.8F));
		
		visitor.visitCollection(result);
		
	}
}
