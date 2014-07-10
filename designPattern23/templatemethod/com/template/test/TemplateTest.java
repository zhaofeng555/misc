package com.template.test;

import com.template.abstractclass.Template;
import com.template.concreteclass.TemplateConcrete;

public class TemplateTest {

	public static void main(String[] args) {
		Template temp = new TemplateConcrete();
		temp.update();
	}

}
