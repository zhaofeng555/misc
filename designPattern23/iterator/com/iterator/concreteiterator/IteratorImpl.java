package com.iterator.concreteiterator;

import java.util.List;

import com.iterator.aggregate.MyList;
import com.iterator.iterator.Iterator;

public class IteratorImpl implements Iterator {

	private MyList list;
	private int index;
	
	public IteratorImpl(MyList list){
		index=0;
		this.list=list;
	}
	
	@Override
	public Object next() {
		Object obj = list.get(index);
		index++;
		return obj;
	}

	@Override
	public void first() {
		index=0;
	}

	@Override
	public void last() {
		index=list.getSize();
	}

	@Override
	public boolean hasNext() {
		return index<list.getSize();
	}

}
