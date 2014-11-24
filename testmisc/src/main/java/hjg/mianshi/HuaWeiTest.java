package hjg.mianshi;

import java.util.ArrayList;
import java.util.List;


public class HuaWeiTest {

	public static void main(String[] args) {
		String s1 = "1,3,5";
		String s2 = "2,4,1,7,5";
		int len1 = 3;
		int len2 = 5;
		HuaWeiTest hwt = new HuaWeiTest();
		System.out.println(hwt.getDiffNum(len1, s1, len2, s2));
	}
	
	public int getDiffNum(int len1, String s1, int len2, String s2)  {
		int count = 0;
		int len = 0;
		String[] arr1 = s1.split(",");
		String[] arr2 = s2.split(",");
		if(len1 > len2) len = len2;
		else len = len1;
		for(int i=0;i<len;i++) {
			System.out.println(arr1[len1-i-1]+" , "+(arr2[len2-i-1]));
			if(arr1[len1-i-1].equals(arr2[len2-i-1])) {
				count ++;
			}
		}
		return count;
	}
	
	public static void test2(String[] args) {
		int len=4;
		String str="3,1,2,4";   
		int m=7;  
		HuaWeiTest hwt = new HuaWeiTest();
		System.out.println(hwt.getOutString(len, str, m));
	}
	public String getOutString(int len, String str, int m) {
		String ret ="";
		String[] arr = str.split(",");
		List<String> ls = new ArrayList<String>();
		for(int i=0;i<len;i++) {
			ls.add(arr[i]);
		}
		for(int i=0;i<len;i++) {
			int temp = (m-1)%ls.size();
			ret += ls.get(temp);
			m = Integer.parseInt(ls.get(temp))+temp;
			ls.remove(temp);
		}
		return ret;
	}
}
