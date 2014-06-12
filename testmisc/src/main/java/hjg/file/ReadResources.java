package hjg.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// jdk1.6 or early
	public static void test1() {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("C:\\testing.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// jdk1.7
	public static void test2() {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
