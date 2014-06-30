package hjg.mianshi;

public class mianshi1_qiuhe {
	public static void main(String[] args) {
		int a[] = { 3, 5, 2, 4, 1, 8,9 };
		int sub[] = new int[a.length];
		int SUM = 10;
		for (int i = 0; i < a.length; i++) {
			int res = a[i];
			sub[0] = a[i];
			int nextIndex = i + 1;
			for (int j = i + 1; j < a.length; j++) {
				res += a[j];
				sub[j - nextIndex + 1] = a[j];
				
				printArr(j - nextIndex + 1, i, sub);
				
				if (res == SUM) {
					for (int x = 0; x <= j - nextIndex + 1; x++) {
						System.out.print(sub[x] + ((x < j - nextIndex + 1) ? "+" : ""));
					}
					System.out.println("=" + SUM);
					j = nextIndex++;
					res = a[i];
					continue;
				} else if (res > 10) {
					j = nextIndex++;
					res = a[i];
					continue;
				}
			}
		}
	}
	
	private static void printArr(int index1, int index2, int arr[]){
		System.out.println(index1+" , "+index2+" : ");
		for (int i : arr) {
			System.out.print(i+"  ");
		}
		System.out.println();
	}
}