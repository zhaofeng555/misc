package struct.flyweight;

import struct.flyweight.flyweight.Flyweight;
import struct.flyweight.flyweight.FlyweightFactory;

public class TestFlyweight {

	public static void main(String[] args) {
		Flyweight fly1 = FlyweightFactory.getFlyweight("a");
		fly1.action(1);
		
		Flyweight fly2 = FlyweightFactory.getFlyweight("b");
		fly2.action(2);
		
		Flyweight fly3 = FlyweightFactory.getFlyweight("c");
		fly3.action(3);
		
		Flyweight fly4 = FlyweightFactory.getFlyweight("c");
		fly4.action(4);
		
		Flyweight fly5 = FlyweightFactory.getFlyweight("c");
		fly5.action(5);
		
		System.out.println(FlyweightFactory.getSize());
	}

	
}
