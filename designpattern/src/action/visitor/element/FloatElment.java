package action.visitor.element;

import action.visitor.visitor.Visitor;

public class FloatElment implements Visitable{

	private Float fe;

	public FloatElment(Float fe) {
		super();
		this.fe = fe;
	}
	public Float getFe() {
		return fe;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visitFloat(this);
	}
	
}
