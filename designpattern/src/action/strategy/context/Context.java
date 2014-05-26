package action.strategy.context;

import action.strategy.strategy.Strategy;

public class Context {

	Strategy stra;
	
	public Context(Strategy stra){
		this.stra=stra;
	}
	
	public void doMethod(){
		stra.method();
	}
	
}
