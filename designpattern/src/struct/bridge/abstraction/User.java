package struct.bridge.abstraction;

import struct.bridge.implementor.Clothing;

public abstract class User {

	private Clothing clothing;
	
	private String type;

	public Clothing getClothing() {
		return clothing;
	}

	public String getType() {
		return type;
	}

	public void setClothing(Clothing clothing) {
		this.clothing = clothing;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public abstract void dress();
	
	
}
