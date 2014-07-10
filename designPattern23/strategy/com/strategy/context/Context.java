package com.strategy.context;

import com.strategy.strategy.Strategy;

public class Context {
	
	public Strategy stra;
	
	public Context(Strategy stra){
		this.stra=stra;
	}
	
	public void doMethod(){
		stra.method();
	}

}
