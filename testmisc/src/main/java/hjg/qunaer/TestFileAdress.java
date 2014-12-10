package hjg.qunaer;

import java.util.Collections;
import java.util.Stack;

public class TestFileAdress {

	public static void main(String[] args) {
//		/home/abs/../temp/new/../
//		/home/temp
		
		String path="/home/abs/../temp/new/../";
		String buf = fileAdress(path);
		System.out.println(buf.toString());
		
	}

	private static String fileAdress(String path) {
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
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < s.size(); i++) {
			buf.append("/").append(s.get(i));
//			System.out.print( "/"+s.get(i));
		}
		return buf.toString();
	}
	
}
