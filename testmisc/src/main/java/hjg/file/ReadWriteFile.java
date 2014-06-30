package hjg.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Date;

/**
 * @author hjg 
 * @version   创建时间：2012-2-7下午10:36:34
 *
 **/
public class ReadWriteFile {

	public static void main(String[] args) throws Exception {
		String readFilePath = "resource/test.txt";
		String writeFilePath = "resource/test2.txt";
		File readFile = new File(readFilePath);
		File writeFile = new File(writeFilePath);
		Reader r = new FileReader(readFile);
		BufferedReader br = new BufferedReader(r);

		FileWriter w = new FileWriter(writeFile);
		BufferedWriter bw = new BufferedWriter(w);

		String s = null;
		while((s=br.readLine())!=null){
			System.out.println(s);
			bw.write(s);
		}
		bw.write(new Date().toLocaleString());
		br.close();
		r.close();
		
		bw.close();
		w.close();
	}
}
