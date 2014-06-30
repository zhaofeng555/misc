package hjg.mianshi;

import java.util.LinkedList;
import java.util.List;

public class mianshi3_qiuhe {

	static int[] a = { 8, 5, 4, 3, 2, 1 };

	static int sum = 10;

	public static void main(String[] args) {
		for (int i = 0; i < a.length; i++)
			subSet(new LinkedList<Integer>(), i);
	}

	public static void printResult(List<Integer> numList) {
		for (int i = 0; i < numList.size(); i++) {
			if (i > 0)
				System.out.print("+");
			System.out.print(numList.get(i));
		}
		System.out.println("=" + sum);
	}

	public static void subSet(List<Integer> numList, int start) {
		int curNum = a[start];

		int total = 0;
		for (int k = 0; k < numList.size(); k++) {
			total += numList.get(k);
		}

		if (total + curNum == sum) {
			numList.add(curNum);
			printResult(numList);
		}

		if (total + curNum < sum) {
			numList.add(curNum);
			for (int i = start + 1; i < a.length; i++) {
				List<Integer> newList = new LinkedList<Integer>();
				newList.addAll(numList);
				subSet(newList, i);
			}
		}
	}
}
