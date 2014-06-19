package hjg.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadResources {

	public static void main(String[] args) {

//	Class.getResource("")    返回的是当前Class这个类所在包开始的为置   
//	Class.getResource("/") 返回的是classpath的位置   
//	getClassLoader().getResource("")  返回的是classpath的位置   
//	getClassLoader().getResource("/")  错误的!!  
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
