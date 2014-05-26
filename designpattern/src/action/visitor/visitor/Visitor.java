package action.visitor.visitor;

import java.util.Collection;

import action.visitor.element.FloatElment;
import action.visitor.element.StringElement;

public interface Visitor {
void visitString(StringElement stringE);
void visitFloat(FloatElment floatE);
void visitCollection(Collection collection);
}
