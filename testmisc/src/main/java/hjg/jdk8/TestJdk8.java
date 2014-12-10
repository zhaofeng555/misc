package hjg.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestJdk8 {

	public static void main(String[] args) {
		testJdk8Stream2();
	}


	public static void testJdk8Stream2() {
		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		natural.map((x) -> {
			return x * x;
		}).limit(10).forEach(System.out::println);
	}

	private static void testJdk8Stream1() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream();
		stream.filter((x) -> {
			return x % 2 == 0;
		}).map((x) -> {
			return x * x;
		}).forEach(System.out::println);
	}

}

class NaturalSupplier implements Supplier<Long> {

	long value = 0;

	public Long get() {
		this.value = this.value + 1;
		return this.value;
	}
}
