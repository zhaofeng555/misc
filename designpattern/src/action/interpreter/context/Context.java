package action.interpreter.context;

import java.util.ArrayList;
import java.util.List;

import action.interpreter.expression.Expression;

public class Context {

	private String content;
	private List<Expression> list = new ArrayList<Expression>();
	public String getContent() {
		return content;
	}
	public List<Expression> getList() {
		return list;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setList(List<Expression> list) {
		this.list = list;
	}
	
	public void add(Expression eps){
		list.add(eps);
	}
}
