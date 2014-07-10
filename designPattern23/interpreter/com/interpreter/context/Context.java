package com.interpreter.context;

import java.util.ArrayList;
import java.util.List;

import com.interpreter.abstractexpression.Expression;

public class Context {

	private String content;

	private List list = new ArrayList();

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void add(Expression eps) {
		list.add(eps);
	}

	public List getList() {
		return list;
	}

}
