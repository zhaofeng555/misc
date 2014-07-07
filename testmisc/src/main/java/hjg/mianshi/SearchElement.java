package hjg.mianshi;

public class SearchElement {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		
		boolean f = FindElem(arr, 10, 2, 2);
		System.out.println(f);
		System.out.println(FindElem(arr, 10, 3, 3));
//		
		String s1="helo";
		String s2="helo";
		
		System.out.println(s1 == s2);
//		int intArr[]=new int[256];
//		for (int i = 0; i < intArr.length; i++) {
//			intArr[i]=i;
//		}
//		String s="aAzZ";
//		char cs[]=s.toCharArray();
//		for (char c : cs) {
//			System.out.println(intArr[c]);
//		}
//		s.charAt(0);
		
		
	}

	static boolean  FindElem(int[][] mat, int elem, int M, int N) {
		int row = 0;
		int col = N - 1;
		while (row < M && col >= 0) {
			if (mat[row][col] == elem) {
				return true;
			} else if (mat[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
}
