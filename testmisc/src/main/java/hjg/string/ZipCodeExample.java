package hjg.string;

import java.text.DecimalFormat;

public class ZipCodeExample {
	public static void main(String[] args) {
		test1();
		test2();
	}
	public static void test1() {
		int zip = 123;
		DecimalFormat format = new DecimalFormat("00000");
		System.out.println(format.format(zip));		
	}
	
	public static void test2() {
		 
		String zip = "00123";
		System.out.println(zip);
 
	}
}
