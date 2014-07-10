package com.flyweight.concreteflyweight;

import com.flyweight.flyweight.Flyweight;

public class FlyweightImpl implements Flyweight {

	@Override
	public void action(int arg) {
		System.out.println("参数值："+arg);
	}

}
