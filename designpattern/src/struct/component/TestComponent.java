package struct.component;

import java.util.List;

import struct.component.component.Employer;
import struct.component.component.Programmer;
import struct.component.composite.ProjectManager;

public class TestComponent {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Employer pm = new ProjectManager("项目经理");
		Employer pa = new ProjectManager("项目助理");
		
		Employer programer1= new Programmer("程序员1");
		Employer programer2= new Programmer("程序员2");
		
		pm.add(pa);
		pm.add(programer2);
		
		System.out.println(pm.getName());
		List<Employer> ems = pm.getEmployers();
		for (Employer e : ems) {
			System.out.println(e.getName());
		}
		
		System.out.println("------------");
		System.out.println(programer1.getName());
		
	}
	
}
