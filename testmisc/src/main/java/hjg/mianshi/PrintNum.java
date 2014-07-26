package hjg.mianshi;

public class PrintNum {

	public void printNumbers() {
		int result = 0;
		int lineNum = 1;
		for (int i = 203; i <= 987; i++) {
			for (int j = 203; j <= 987; j++) {
				result = i + j;
				if (isTrue(result, i, j)) {
					System.out.print(i + " + "+ j + " = "+ result + "\t");
					// 每行显示三个
					if (lineNum % 3 == 0) {
						System.out.println();
					}
					lineNum++;
				}else{
//					System.out.print(i +" , "+j);
				}
			}
		}
	}

	public boolean isTrue(int result, int i, int j) {
		String str = "0123456789";
		String s = result + "" + i + "" + j;

		for (int k = 0; k < str.length(); k++) {
			if (!s.contains(str.substring(k, k + 1))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		new PrintNum().printNumbers();
		
	}
}
