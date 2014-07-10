package com.interpreter.expression;

import com.interpreter.abstractexpression.Expression;
import com.interpreter.context.Context;

public class SimpleExpression extends Expression {

	@Override
	public void interpret(Context ctx) {
		System.out.println("这是普通解析器！");
	}

}
