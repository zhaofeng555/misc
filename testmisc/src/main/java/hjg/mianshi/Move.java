package hjg.mianshi;

/**
 * @author hjg
 * @version 创建时间：2010-6-6下午08:20:44 类说明
 * 
 **/
public class Move {
	public static int[] move(int[] array) {
//		int m = 0;
//		for (int i = 0; i < array.length; i++)
//			m += array[i] == 0 ? 1 : 0;
		
//		for (int i=0; i<array.length;i++)
//			System.out.print(array[i]+"  ,  ");
//		System.out.println();
//		System.out.println(m);
		
		// 自右向左扫描，将所有非零元素紧凑到右侧
		int low, high;
		for (low = array.length - 1, high = low; low >= 0; low--){
			if (array[low] != 0) {
				array[high] = array[low];
				high--;// 更新紧凑序列的最左侧元素
			}
		}
		// 将余下m个元素全部置为0
		for (; high >= 0; high--)
			array[high] = 0;
		return array;
	}

	public static void main(String[] argv) {
		int[] array = { 1, 0, 3, 0, 0, -34, 786, 99, 0, 6, 100, 0, 0, 99, 0, 10, 4 };
		for (int i = 0; i < array.length; i++)
			System.out.print(" " + array[i]);
		System.out.println("");
		array = move(array);
		for (int i = 0; i < array.length; i++)
			System.out.print(" " + array[i]);
		System.out.println("");
	}
}
