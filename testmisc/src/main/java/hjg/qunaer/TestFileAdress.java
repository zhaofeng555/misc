package hjg.qunaer;

import java.util.Collections;
import java.util.Stack;

public class TestFileAdress {

	public static void main(String[] args) {
//		/home/abs/../temp/new/../
//		/home/temp
		
		String path="/home/abs/../temp/new/../";
		Stack<String> s = new Stack<String>();
		String dirs[]=path.split("\\/");
		for (String d : dirs) {
			if("..".equals(d) && !s.isEmpty()){
				s.pop();
			}else if(!d.isEmpty()){
				s.push(d);
			}
			System.out.println(d);
		}
		for (int i = 0; i < s.size(); i++) {
			System.out.print( "/"+s.get(i));
		}
		System.out.println(s);
		System.out.println(dirs.length);
		
	}
	
}
