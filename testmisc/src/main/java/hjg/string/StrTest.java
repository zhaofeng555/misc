package hjg.string;

public class StrTest {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		String m = subString(str, 5, "a");
		
		//运行结果 abcda
		System.out.println(m);
	}

	public static String subString(String str, int toCount, String more){
		int reInt = 0;
		String  reStr = "";
		if(str == null)
			return "";
		char[] tempChar = str.toCharArray();
		for(int kk = 0; (kk < tempChar.length && toCount > reInt); kk++){
			String s1 = str.valueOf(tempChar[kk]);
			byte[] b= s1.getBytes();
			reInt += b.length;
			reStr += tempChar[kk];
		}
		if(toCount == reInt || toCount == reInt-1){
			reStr += more;
		}
		return reStr;
	}

	public static void testSameRef() {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = "ab" + "c";
		String str4 = new String(str2);

		// str1和str2引用自常量池里的同一个string对象
		print(str1, str2);
		// str3通过编译优化，与str1引用自同一个对象
		print(str1, str3);
		// str4因为是在堆中重新分配的另一个对象，所以它的引用与str1不同
		print(str1, str4);
		
		print(str2, str3);
		print(str2, str4);
	}

	public static void print(String s1, String s2) {
		System.out.println(s1 + " == " + s2 + " = " + (s1 == s2));
	}

}
