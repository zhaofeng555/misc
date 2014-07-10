package com.interpreter.test;

import com.interpreter.abstractexpression.Expression;
import com.interpreter.context.Context;
import com.interpreter.expression.AdvanceExpression;
import com.interpreter.expression.SimpleExpression;

public class InterpreterTest {

	public static void main(String[] args) {
		Context ctx = new Context();
		ctx.add(new SimpleExpression());
		ctx.add(new AdvanceExpression());
		ctx.add(new SimpleExpression());
		
		for ( Object obj: ctx.getList()) {
			Expression eps =(Expression)obj;
			eps.interpret(ctx);
		}
	}

}
