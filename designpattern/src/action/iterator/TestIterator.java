package action.iterator;

import action.iterator.aggretate.List;
import action.iterator.aggretate.ListImpl;
import action.iterator.iterator.Iterator;

public class TestIterator {

	public static void main(String[] args) {
		List list = new ListImpl();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//第一种
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("-------------------------");
		//第二种
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
