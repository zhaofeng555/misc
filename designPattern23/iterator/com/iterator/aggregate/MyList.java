package com.iterator.aggregate;

import com.iterator.iterator.Iterator;

public interface MyList {

	Iterator iterator();
	Object get(int index);
	int getSize();
	void add(Object obj);
	
}
