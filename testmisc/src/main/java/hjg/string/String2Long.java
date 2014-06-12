package hjg.string;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class String2Long {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		test0();
		test1();
		test2();
	}

	private static void test0() {
		String bigNumber = "1234567899";
		long result = Long.valueOf(bigNumber);
		System.out.println(result);
	}

	private static void test1() {
		String bigNumber = "1,234,567,899";
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		Number number = 0;
		try {
			number = format.parse(bigNumber);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long result = number.longValue();
		System.out.println(result);
	}

	private static void test2() {
		String bigNumber = "1,234,567,899";
		long result = Long.valueOf(bigNumber.replaceAll(",", "").toString());
		System.out.println(result);
	}

}
