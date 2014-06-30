package hjg.mianshi;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 现在有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来
 */
public class Get10_100 {
	public static void main(String[] args) {   
//        test();   
//        System.out.println("----------");
//        test2();   
//        test3();   
		
		BitSet bs  = new BitSet(100000000);
		bs.set(1, true);
		bs.set(2, false);
		bs.set(3, false);
		bs.set(4, true);    
		System.out.println(bs);
		System.out.println(bs.toByteArray());
		
    }

	private static void test() {
		int count = 100;   
        Map map = new HashMap(count);   
        for (int i = 1; i <= count; i++) {   
            map.put(i, i);   
        }   
        Random ran = new Random();   
        for (int i = 0; i < count / 10; i++) {   
            int n = ran.nextInt(count);   
            map.put(n, null);   
        }   
        System.out.println(map);
	}  
	
	private static void test2(){
		   
        int[] randomNums = new int[10];   
        Random random = new Random();   
        for (int i = 0, length = randomNums.length; i < length; i++) {   
            randomNums[i] = random.nextInt(100);   
        }   
        for (int i : randomNums) {
			System.out.print(i+" \t");
		}
        long start = System.currentTimeMillis();   
        boolean[] bitArray = new boolean[100];   
        for (int i = 0, length = randomNums.length; i < length; i++) {   
            bitArray[randomNums[i]] = true;   
        }   
        for (int i = 0, length = bitArray.length; i < length; i++) {   
            if (bitArray[i]) {   
            	System.out.println("出现过 ： "+i);   
            }else{
            	continue;   
            }
        }   
        long end = System.currentTimeMillis();   
        System.out.println("Spend milliseconds: " + (end - start));
        for(Boolean b : bitArray){
        	System.out.print(b);
        	System.out.print("\t");
        }
	}
	
	private static void test3(){
		BitSet bs  = new BitSet(100000000);// 
		for(int i=0;i<100000000;i++){ 
		    bs.set(i%100,false); 
		} 
		for(int i=0;i<100000000 ;i++){ 
		    if(!bs.get(i)){ 
		          //  i 为所需结果 
		    	System.out.println(i);
		    }else{
		    	 
		     }
		} 
	}
	

}
