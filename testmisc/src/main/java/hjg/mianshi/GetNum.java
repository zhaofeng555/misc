package hjg.mianshi;

import java.util.ArrayList;
import java.util.List;

public class GetNum {

	public static void main(String[] args) {

		int n = 10;
		List<Integer> pL = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			pL.add(i + 1);
		}

		int count = 3;
		for (int i = 0; i < n - 1; i++) {
			int temp = (count - 1) % pL.size();// 要移除的位置
			pL.remove(temp);
			count = temp + 3; // 保留被移除的位置，再加上计数
		}

		System.out.println(pL.get(0));

	}

}
