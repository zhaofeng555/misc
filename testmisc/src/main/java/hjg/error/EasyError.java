package hjg.error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EasyError {

	public static void main(String[] args) {
		String arr[]={"hello","world"};
		String targetValue="hello";
//		testList(arr);
//		System.out.println(testContain1(arr, targetValue));
//		System.out.println(testContain2(arr, targetValue));
//		System.out.println(testContain3(arr, targetValue));
		
//		testListRemove3();
		List<String> list = new ArrayList<String>();   
	    add2List(list,10);   
	    String s = list.get(0);  

	}

	private static void testListRemove1() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
		for(int i=0;i<list.size();i++){
		    list.remove(i);
		}
		//[b,d] 
		System.out.println(list);
	}
	private static void testListRemove2() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
		for(String s:list){
		    if(s.equals("a")){
		        list.remove(s);
		    }
		}
		//Exception in thread "main" java.util.ConcurrentModificationException
		System.out.println(list);
	}
	private static void testListRemove3() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
		        String s = iter.next();
		        if(s.equals("a")){
		            iter.remove();
		    }
		}
		//.next()必须在.remove()之前调用。
		//在一个foreach循环中，编译器会使.next()在删除元素之后被调用，因此就会抛出ConcurrentModificationException异常
		System.out.println(list);
		
	}
	public static void add2List(List list,Object o){   
	    list.add(o);   
	}   
	    

	
	private static boolean testContain1(String[]arr, String targetValue){
		Set<String> set = new HashSet<String>(Arrays.asList(arr));    
		return set.contains(targetValue);
	}
	private static boolean testContain2(String[]arr, String targetValue){
		return Arrays.asList(arr).contains(targetValue); 
	}
	private static boolean testContain3(String[]arr, String targetValue){
		for(String s:arr){   
		    if(s.equals(targetValue)){   
		        return true;   
		    }   
		}   
		return false; 
	}

	private static void testList(String arr[]) {
		List<String> list = Arrays.asList(arr);  
		System.out.println(list);
		System.out.println(list.size());
		
		
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));  
		System.out.println(arrayList);
		System.out.println(arrayList.size());
	}
	
}
