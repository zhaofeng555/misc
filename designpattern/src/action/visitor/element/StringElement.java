package action.visitor.element;

import action.visitor.visitor.Visitor;

public class StringElement implements Visitable{

	private String se;

	public StringElement(String se) {
		super();
		this.se = se;
	}

	public String getSe() {
		return se;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitString(this);
	}
	
}
