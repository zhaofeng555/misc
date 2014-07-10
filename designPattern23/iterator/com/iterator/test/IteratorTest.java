package com.iterator.test;

import com.iterator.aggregate.MyList;
import com.iterator.concreteaggregate.ListImpl;
import com.iterator.iterator.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		MyList list = new ListImpl();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//第一种
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("===============");
		//第二种
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
