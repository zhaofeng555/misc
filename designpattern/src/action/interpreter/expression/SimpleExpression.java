package action.interpreter.expression;

import action.interpreter.context.Context;

public class SimpleExpression extends Expression {

	@Override
	public void interpret(Context ctx) {
		System.out.println("这个是普通解析器！！！");
	}

}
