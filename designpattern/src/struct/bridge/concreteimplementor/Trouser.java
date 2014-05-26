package struct.bridge.concreteimplementor;

import struct.bridge.abstraction.User;
import struct.bridge.implementor.Clothing;

public class Trouser extends Clothing {

	@Override
	public void personDressCloth(User user) {
		System.out.println(user.getType()+"穿裤子");
	}

}
