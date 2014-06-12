package hjg.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaCtrlCSV {

	String csvFile = "resource/test.csv";
	public static void main(String[] args) {

		JavaCtrlCSV obj = new JavaCtrlCSV();
		obj.writeCsv();
		obj.readCsv();
	}

	public void writeCsv() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(csvFile));
			String con = "hello,world,nihao";
			System.out.println(con);
			bw.write(con);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public void readCsv() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			String line = "";
			while ((line = br.readLine()) != null) {

				String[] content = line.split(",");
				System.out.println(content);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {br.close();} catch (IOException e) {}
			}
		}
	}
}
