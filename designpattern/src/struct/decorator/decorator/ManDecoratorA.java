package struct.decorator.decorator;

public class ManDecoratorA extends Decorator {

	@Override
	public void eat() {
		super.eat();
		reEat();
		System.out.println("ManDecoratorA 类");
	}
	
	public void reEat(){
		System.out.println("再吃一顿饭");
	}
	
}
