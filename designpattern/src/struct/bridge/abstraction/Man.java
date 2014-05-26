package struct.bridge.abstraction;

import struct.bridge.implementor.Clothing;

public class Man extends User {

	public Man(){
		setType("男人");
	}
	
	public void dress(){
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}
	
}
