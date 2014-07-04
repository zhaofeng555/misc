package hjg.mianshi;

import java.util.Scanner;

public class mianshi8 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		System.out.println(num);
		int i = 0;
		StringBuffer buffer = new StringBuffer();
		while (i < num) {
			String line[] = in.nextLine().split("\\s");
			int first = fromStringToInt(line[0]);
			int second = fromStringToInt(line[1]);
			String res = fromIntToString(first + second).toString();
			System.out.println("res = "+res);
			buffer.append(res);
			buffer.append("\n");
			i++;
		}
		System.out.print(buffer);

	}

	public static int fromStringToInt(String str) {

		int sum = 0;
		int i = str.indexOf("i");
		if (i != -1) {
			if (i > 0) {
				char iPrefix = str.charAt(i - 1);
				if (Character.isDigit(iPrefix)) {
					sum = sum + (iPrefix - 48);
				} else
					sum += 1;
			} else
				sum += 1;
		}

		int x = str.indexOf("x");
		if (x != -1) {
			if (x > 0) {
				char xPrefix = str.charAt(x - 1);
				if (Character.isDigit(xPrefix)) {
					sum = sum + (xPrefix - 48) * 10;
				} else
					sum += 10;
			} else
				sum += 10;
		}

		int c = str.indexOf("c");
		if (c != -1) {

			if (c > 0) {
				char cPrefix = str.charAt(c - 1);
				if (Character.isDigit(cPrefix)) {
					sum = sum + (cPrefix - 48) * 100;
				} else
					sum += 100;
			} else
				sum += 100;

		}
		int m = str.indexOf("m");
		if (m != -1) {
			if (m == 0)
				sum += 1000;
			else {
				char mPrefix = str.charAt(m - 1);

				sum = sum + (mPrefix - 48) * 1000;

			}
		}
		return sum;
	}

	public static StringBuffer fromIntToString(int a) {
		StringBuffer str = new StringBuffer();

		int m = a / 1000;
		int c = a % 1000 / 100;
		int x = a % 1000 % 100 / 10;
		int i = a % 10;

		str.append(m + "m" + c + "c" + x + "x" + i + "i");
		int zeroindex = str.indexOf("0");
		while (zeroindex != -1) {
			str.delete(zeroindex, zeroindex + 2);
			zeroindex = str.indexOf("0");
		}
		int oneindex = str.indexOf("1");
		while (oneindex != -1) {
			str.deleteCharAt(oneindex);
			oneindex = str.indexOf("1");
		}
		return str;
	}
}

