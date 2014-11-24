package hjg.eclipse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DebugTest {
	
	void t1(){
		
	}

	public static void main(String[] args) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int nextInt = r.nextInt();
			list.add(nextInt);
		}

		if(list.size()>10){
			throw new IOException("捕获固定类型的异常");
		}
		
		for (Integer n : list) {
			System.out.println(n);
		}
	}
	
	void t2(){
		t1();
	}

}
