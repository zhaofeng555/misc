package hjg.mianshi;

/**
 * @author hjg
 * @version 创建时间：2012-2-7上午09:12:34
 * 
 **/
public class Grid {

	public static void main(String[] args) {
		int a[][] = getGrid(5);
		printArray(a);
	}

	private static void printArray(int[][] a) {
		for (int[] is : a) {
			for (int i : is) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}
	}

	public static int[][] getGrid(int n) {
		int[][] array = new int[n][n];
		int row = 0, col = 0, m = 1;
		// 用于控制奇偶组，false表示偶组，true表示奇组
		boolean isRow = false;
		// i表示当前组的索引，从0开始
		for (int i = 0; i < (2 * n - 1); i++) {
			row = i;
			while (row >= ((i < n) ? 0 : i - n + 1)) {
				// 如果处理的是右下角表格中的数字，行或列最大不能超过n-1
				if (row > (n - 1))
					row = n - 1;
				col = i - row;
				if (isRow)
					array[row][col] = m;
				else
					// 将row变成列，将col变成行
					array[col][row] = m;
				m++;
				row--;
//				printArray(array);
//				System.out.println("---------------------------------------");
			}
			// 切换奇偶组
			isRow = !isRow;
		}
		return array;
	}

}
