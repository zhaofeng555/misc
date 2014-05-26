package action.interpreter.expression;

import action.interpreter.context.Context;

public class AdvanceExpression extends Expression {

	@Override
	public void interpret(Context ctx) {
		System.out.println("这是高级解析器！");
	}

}
