package hjg.mianshi;

public class Utils {

	public static void printArray(String string, int[] arr) {
		System.out.println(string);
		for (int a : arr) {
			System.out.print(a+"\t");
		}
		System.out.println();
	}
	public static<T> void printArray(T[] arr) {
		for (T a : arr) {
			System.out.print(a+"\t");
		}
		System.out.println();
	}

}
