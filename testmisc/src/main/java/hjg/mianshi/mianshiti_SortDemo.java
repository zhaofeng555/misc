package hjg.mianshi;

public class mianshiti_SortDemo {

	public static void main(String[] args) {
		String arr[] = { "13", "22", "34", "44", "42", "45", "67", "68", "69", "33", "21", "88", "99", "18", "65",
				"21", "85", "47", "96", "85", "47", "14", "12", "17", "19", "24", "98" };
		int[][] array = init(sort(arr));
		printArray(array);
		System.out.println();
		int[][] temp = convert(array);
		printArray(temp);
	}

	public static int[][] convert(int[][] array) {
		int[][] temp = new int[array[0].length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				temp[i][j] = array[j][i];
			}
		}
		return temp;
	}

	private static int[][] init(String[] array) {
		int k = 0;
		int[][] arr = new int[array.length / 5][5];
		for (int i = 0; i < array.length / 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(array[k++]);
			}
		}
		return arr;
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static String[] sort(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				int a = Integer.parseInt(array[i]);
				int b = Integer.parseInt(array[j]);
				if (a < b) {
					int temp = a;
					a = b;
					b = temp;
				}
				array[i] = a + "";
				array[j] = b + "";
			}
		}
		return array;
	}

}
