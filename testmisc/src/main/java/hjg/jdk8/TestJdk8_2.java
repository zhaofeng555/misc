package hjg.jdk8;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestJdk8_2 {

	public static void main(String[] args) {
		test3();
	}

	private static void test3() {
		Stream<Double> piStream3 = Stream.generate(new PiSupplier());
		piStream3.map(new EulerTransform())
		         .map(new EulerTransform())
		         .map(new EulerTransform())
		         .map(new EulerTransform())
		         .map(new EulerTransform())
		         .limit(20)
		         .forEach(System.out::println);
	}
	private static void test2() {
		Stream<Double> piStream2 = Stream.generate(new PiSupplier());
		piStream2.map(new EulerTransform())
		.limit(10)
		.forEach(System.out::println);
	}

	private static void test1() {
		Stream<Double> piStream = Stream.generate(new PiSupplier());
		piStream.skip(100).limit(10).forEach(System.out::println);
	}
}
class PiSupplier implements Supplier<Double> {

	double sum = 0.0;
	double current = 1.0;
	boolean sign = true;

	@Override
	public Double get() {
		sum += (sign ? 4 : -4) / this.current;
		this.current = this.current + 2.0;
		this.sign = !this.sign;
		return sum;
	}
}

class EulerTransform implements Function<Double, Double> {

    double n1 = 0.0;
    double n2 = 0.0;
    double n3 = 0.0;

    @Override
    public Double apply(Double t) {
        n1 = n2;
        n2 = n3;
        n3 = t;
        if (n1 == 0.0) {
            return 0.0;
        }
        return calc();
    }

    double calc() {
        double d = n3 - n2;
        return n3 - d * d / (n1 - 2 * n2 + n3);
    }
}


