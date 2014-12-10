package hjg.random;

public class TestRandom {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(new java.util.Random().nextInt(10)+"\t");
			System.out.print(Math.random()+"\t");
			System.out.print(Math.round(Math.random())+"\t");
			System.out.print(Math.round(Math.random() * 10)+"\t");
			
			System.out.println(java.util.concurrent.ThreadLocalRandom.current().nextInt(10)+"\t");
		}
	}
}
