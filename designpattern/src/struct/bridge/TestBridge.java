package struct.bridge;

import struct.bridge.abstraction.Lady;
import struct.bridge.abstraction.Man;
import struct.bridge.abstraction.User;
import struct.bridge.concreteimplementor.Jacket;
import struct.bridge.concreteimplementor.Trouser;
import struct.bridge.implementor.Clothing;

public class TestBridge {

	public static void main(String[] args) {
		User man = new Man();
		User lady = new Lady(); 
		
		Clothing jacket = new Jacket();
		Clothing trouser = new Trouser();
		
		jacket.personDressCloth(man);
		man.setClothing(trouser);
		man.dress();
		trouser.personDressCloth(man);
		
		System.out.println("------------");
		
		jacket.personDressCloth(lady);
		trouser.personDressCloth(lady);
		
	}

}
