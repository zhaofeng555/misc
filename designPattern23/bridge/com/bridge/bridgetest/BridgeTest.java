package com.bridge.bridgetest;

import com.bridge.abstraction.Person;
import com.bridge.concreteimplementor.Jacket;
import com.bridge.concreteimplementor.Trouser;
import com.bridge.implementor.Clothing;
import com.bridge.refinedabstraction.Lady;
import com.bridge.refinedabstraction.Man;

public class BridgeTest {

	public static void main(String[] args) {
		Person man = new Man();
		Person lady = new Lady();
		
		Clothing jacket = new Jacket();
		Clothing trouser = new Trouser();
		
		jacket.personDressCloth(man);
		trouser.personDressCloth(man);
		
		jacket.personDressCloth(lady);
		trouser.personDressCloth(lady);
	}

}
