package hjg.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeMap;

public class TestOrder {

	public static void main(String[] args) throws Exception {
		test1();
		printMethodAnnotation();
		invokMethodByAnnotaion();
	}

	private static void invokMethodByAnnotaion() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Class c = Class.forName("hjg.annotation.Tarena");
		Object o=c.newInstance();
		
		TreeMap tm = new TreeMap();
		Method[] ms = c.getMethods();
		for (Method m : ms) {
			if(m.isAnnotationPresent(Order.class)){
				Order order = m.getAnnotation(Order.class);
				int val = order.value();
				tm.put(val, m);
			}
		}
		
		Set s = tm.keySet();
		for (Object i : s) {
			Method m =(Method)tm.get(i);
			m.invoke(o);
		}
	}

	private static void printMethodAnnotation() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class c = Class.forName("hjg.annotation.Tarena");
		Object o=c.newInstance();
		
		TreeMap tm = new TreeMap();
		Method[] ms = c.getMethods();
		for (Method m : ms) {
			Annotation an[]=m.getAnnotations();
			if(an.length>0){
				System.out.print("method = "+m.getName());
				System.out.println(" , annotation = "+an[0]);
			}
		}
	}

	private static void test1() {
		Tarena t = new Tarena();
		t.studyCoreCpp();
	}
	
}
