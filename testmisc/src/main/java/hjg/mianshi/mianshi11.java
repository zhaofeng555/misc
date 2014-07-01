package hjg.mianshi;

public class mianshi11 {
	public static void main(String[] args) {
		int num = 9;
		String str = "hello";
		setStr(str);
		System.out.println(str);
		setInt(num);
		System.out.println(num);

		int[] mynum = { 1, 2 };
		System.out.println("----------");
		
		printnum(mynum);
		setnewint(mynum);
		printnum(mynum);
	}

	public static void setStr(String str) {
		str = "world";
	}

	public static void setInt(int num) {
		num = 100;
	}

	static void setnewint(int[] num) {
		num[0] = 100;
	}

	static void printnum(int num[]) {
		for (int i : num) {
			System.out.println(i);
		}
	}
}

