package struct.decorator;

import struct.decorator.componnet.Man;
import struct.decorator.decorator.ManDecoratorA;
import struct.decorator.decorator.ManDecoratorB;

public class TestDecorator {

	public static void main(String[] args) {
		Man man = new Man();
		ManDecoratorA md1 = new ManDecoratorA();
		ManDecoratorB md2 = new ManDecoratorB();
		
		md1.setPerson(man);
		md2.setPerson(md1);
		md2.eat();
	}

}
