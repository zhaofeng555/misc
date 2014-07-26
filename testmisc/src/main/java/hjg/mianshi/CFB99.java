package hjg.mianshi;

public class CFB99 {

	public static void main(String[] args) {
		for (int i = 1, j = 1; i <= 9; j++) {
			System.out.print(j + "*" + i + "=" + i * j + "\t");
			if (j == i) {
				i++;
				j = 0;
				System.out.println();
			}
		}
	}
}