package hjg.mianshi;

import java.util.Stack;

public class mianshi2_qiuhe {

	private int[] a = { 8, 5, 4, 3, 2, 1 };
	private int sum = 10;
	private Stack<Integer> stack = new Stack<Integer>();
	private int stackSum = 0;

	private void calc(int from, int to) {
		if (stackSum == sum) {
			for (Integer i : stack)
				System.out.print(i + " ");
			System.out.println();
			return;
		}

		for (int i = from; i < to; i++) {
			if (stackSum + a[i] <= sum) {
				stackSum += stack.push(a[i]);
				calc(i + 1, to);
				stackSum -= stack.pop();
			}
		}
	}

	public void subsets() {
		calc(0, a.length);
	}

	public static void main(String[] args) {
		new mianshi2_qiuhe().subsets();
	}
}
