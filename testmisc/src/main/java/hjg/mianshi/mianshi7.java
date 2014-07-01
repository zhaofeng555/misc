package hjg.mianshi;

import java.math.BigDecimal;

public class mianshi7 {

	public static void main(String[] args) {

		BigDecimal big = new BigDecimal(1);
		for (int i = 1; i < 1001; i++) {
			big = big.multiply(new BigDecimal(i));
		}
		big.setScale(100);
		System.out.println(big);
	}

}