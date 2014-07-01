package hjg.mianshi;

public class mianshi5 {
	public static void main(String[] args) {   
	    int[] array = { 3, 5, 2, 4, 1, 8 };   
	    final boolean[] bucket = new boolean[10];   
	    for (int num : array) {   
	        bucket[num] = true;   
	    }   

	    int length = bucket.length / 2;   
	    for (int i = 1; i < length; i++) {   
	        if (bucket[i] && bucket[9 - i]) {
	            System.out.println(i + "+" + (9- i) + "=10");   
	        }   
	    } 
	}
}
