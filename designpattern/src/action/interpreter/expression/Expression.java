package action.interpreter.expression;

import action.interpreter.context.Context;

public abstract class Expression {
	public abstract void interpret(Context ctx);
}
