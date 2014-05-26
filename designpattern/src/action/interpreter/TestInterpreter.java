package action.interpreter;

import action.interpreter.context.Context;
import action.interpreter.expression.AdvanceExpression;
import action.interpreter.expression.Expression;
import action.interpreter.expression.SimpleExpression;

public class TestInterpreter {

	public static void main(String[] args) {
		Context ctx = new Context();
		ctx.add(new SimpleExpression());
		ctx.add(new AdvanceExpression());
		ctx.add(new SimpleExpression());
		
		for (Expression eps : ctx.getList()) {
			eps.interpret(ctx);
		}
	}
}
