package struct.bridge.abstraction;

import struct.bridge.implementor.Clothing;

public class Lady extends User {

	public Lady(){
		setType("女人");
	}
	
	public void dress(){
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}
	
}
