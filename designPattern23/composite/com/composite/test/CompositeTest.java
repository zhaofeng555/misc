package com.composite.test;

import java.util.List;

import com.composite.component.Employer;
import com.composite.composite.ProjectManager;
import com.composite.leaf.Programmer;
import com.composite.leaf.ProjectAssistant;

public class CompositeTest {

	public static void main(String[] args) {
		Employer pm = new ProjectManager("项目经理");
		Employer pa = new ProjectAssistant("项目助理");
		
		Employer programer1 = new Programmer("程序员一");
		Employer programer2 = new Programmer("程序员二");
		
		pm.add(pa);
		pm.add(programer2);
		
		List emps = pm.getEmployers();
		for (Object em : emps) {
			Employer e=(Employer)em;
			System.out.println(e.getName());
		}
		
	}

}
