package hjg.mianshi;

/**
 * 不用第三个数，交互两个数的值
 * @author 建国
 *
 */
public class Exchange2Number {

	public static void main(String[] args) {
		test2();
	}
	
	public static void test1(){
		int a=10, b=5;
		System.out.println("a = "+a+" , b = "+b);
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("a = "+a+" , b = "+b);
	}
	public static void test2(){
		int a=10, b=5;
		System.out.println("a = "+a+" , b = "+b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a = "+a+" , b = "+b);
	}
	
}
