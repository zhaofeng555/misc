package action.strategy;

import action.strategy.context.Context;
import action.strategy.strategy.StrategyImplA;
import action.strategy.strategy.StrategyImplB;
import action.strategy.strategy.StrategyImplC;

public class TestStrategy {

	public static void main(String[] args) {
		Context ctx = new Context(new StrategyImplA());
		ctx.doMethod();

		ctx = new Context(new StrategyImplB());
		ctx.doMethod();

		ctx = new Context(new StrategyImplC());
		ctx.doMethod();
	}

}
