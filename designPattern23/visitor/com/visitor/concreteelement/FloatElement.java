package com.visitor.concreteelement;

import com.visitor.element.Visitable;
import com.visitor.visitor.Visitor;

public class FloatElement implements Visitable {

	private Float floatE;
	
	public FloatElement(Float floatE){
		this.floatE=floatE;
	}
	
	public Float getFloatE(){
		return this.floatE;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitFloat(this);
	}

}
