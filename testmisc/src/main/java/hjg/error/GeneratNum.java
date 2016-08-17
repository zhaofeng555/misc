package hjg.error;

public class GeneratNum {

	public static void main(String[] args) {
		Long n = 17L;
		System.out.println(Long.toHexString(n));
		System.out.println(Long.toBinaryString(n));
		System.out.println(Long.toOctalString(n));
//		Integer.toString(n, 10)
	}
	
}
