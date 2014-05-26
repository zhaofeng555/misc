package action.iterator.aggretate;

import action.iterator.iterator.Iterator;

public interface List {

	Iterator iterator();
	Object get(int index);
	int getSize();
	void add(Object obj);
	
}
