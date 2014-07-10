package com.state.test;

import com.state.concretestatesubclasses.Rain;
import com.state.concretestatesubclasses.Sunshine;
import com.state.context.Context;

public class StateTest {

	public static void main(String[] args) {
		Context ctx1 = new Context();
		ctx1.setWeather(new Sunshine());
		System.out.println(ctx1.weatherMessage());
		
		System.out.println("---------------");
		
		Context ctx2 = new Context();
		ctx2.setWeather(new Rain());
		System.out.println(ctx2.weatherMessage());
	}

}
