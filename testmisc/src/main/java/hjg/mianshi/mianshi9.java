package hjg.mianshi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class mianshi9 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		String line = "";
		double current;
		double previous;

		line = in.nextLine();
		previous = Double.parseDouble(line);

		while (true) {
			line = in.nextLine();
			if (line.equals("999"))
				break;
			current = Double.parseDouble(line);

			double sub = current - previous;
			DecimalFormat df = new DecimalFormat("#.00");

			buffer.append(df.format(sub) + "\n");
			previous = current;

		}
		System.out.print(buffer);
		System.out.println("End of Output");

	}
}