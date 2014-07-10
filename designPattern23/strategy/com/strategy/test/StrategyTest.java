package com.strategy.test;

import com.strategy.concretestrategy.StrategyImplA;
import com.strategy.concretestrategy.StrategyImplB;
import com.strategy.concretestrategy.StrategyImplC;
import com.strategy.context.Context;

public class StrategyTest {

	public static void main(String[] args) {
		Context ctx = new Context(new StrategyImplA());
		ctx.doMethod();
		
		ctx = new Context(new StrategyImplB()); 
		ctx.doMethod();

		ctx = new Context(new StrategyImplC()); 
		ctx.doMethod();
	}

}
