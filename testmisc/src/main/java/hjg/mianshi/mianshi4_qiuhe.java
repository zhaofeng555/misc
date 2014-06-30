package hjg.mianshi;

public class mianshi4_qiuhe {
	public static void main(String[] args) {
		int a[] = { 3, 5, 2, 4, 1, 8 };

		int SUM = 10;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == SUM) {
					System.out.println(a[i] + "+" + a[j] + "=10");
					continue;
				} else {
					for (int m = j + 1; m < a.length; m++) {
						if (a[i] + a[j] + a[m] == SUM) {
							System.out.println(a[i] + "+" + a[j] + "+" + a[m] + "=10");
							continue;
						} else {
							for (int n = m + 1; n < a.length; n++) {
								if (a[i] + a[j] + a[m] + a[n] == SUM) {
									System.out.println(a[i] + "+" + a[j] + "+" + a[m] + "+" + a[n] + "=10");
									continue;
								}
							}
						}
					}
				}
			}
		}
	}

}
