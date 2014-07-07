package hjg.mianshi;


public class ReplaceStr {

	public static void main(String[] args) {
		 char ss[] = "he lloss".toCharArray();
		 System.out.println(ss);
		 ReplaceFun(ss, 4);
		// System.out.println(ss);
		int m[][] = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 },
				{ 1, 1, 1, 1 }, };
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j < m[0].length; j++) {
//				System.out.print(m[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		System.out.println("------------------");
//		setZeros(m);
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j < m[0].length; j++) {
//				System.out.print(m[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}

		String s1="waterbottle";
		String s2="erbottlewat";
		boolean f = isRotation(s1, s2);
		System.out.println(f);
	}

	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}

	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		System.out.println("==========================");
		for (int j = 0; j < column.length; j++) {
			System.out.print(column[j]);
			System.out.print(" ");
		}
		System.out.println("====================++++++++++");
		for (int i = 0; i < row.length; i++) {
			System.out.print(row[i]);
			System.out.print(" ");
		}
		System.out.println("++++++++++++++++++++++");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len == s2.length() && len>0){
			String s1s1 = s1+s1;
			return s1s1.contains(s2);
		}
		return false;
	}
	
}
