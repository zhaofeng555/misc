package struct.component.composite;

import java.util.ArrayList;

import struct.component.component.Employer;

public class ProjectManager extends Employer {

	@SuppressWarnings("rawtypes")
	public ProjectManager(String name){
		setName(name);
		employers=new ArrayList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(Employer employer) {
		employers.add(employer);
	}

	@Override
	public void delete(Employer employer) {
		employers.remove(employer);
	}

}
