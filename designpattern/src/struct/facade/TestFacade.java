package struct.facade;

import struct.facade.facade.Facade;
import struct.facade.service.ServiceA;
import struct.facade.service.ServiceAImpl;
import struct.facade.service.ServiceB;
import struct.facade.service.ServiceBImpl;

public class TestFacade {

	public static void main(String[] args) {
		ServiceA sa = new ServiceAImpl();
		ServiceB sb = new ServiceBImpl();
		sa.methodA();
		sb.methodB();
		
		System.out.println("==================");
		
		Facade facade = new Facade();
		facade.methodA();
		facade.methodB();
	}
	
}
