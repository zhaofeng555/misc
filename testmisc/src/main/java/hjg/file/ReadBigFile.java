package hjg.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadBigFile {

	void stream2Buffered() throws Exception{
		File file = new File("path");
		InputStream is = new FileInputStream(file);
		BufferedInputStream fis = new BufferedInputStream(is);
		InputStreamReader  iss = new InputStreamReader(fis, "utf-8");
		BufferedReader reader = new BufferedReader(iss, 5*1024*1024); 
		String line="";
		while((line=reader.readLine()) != null){
			//print ........
		}
		reader.close();
		iss.close();
		fis.close();
		is.close();

	}
	
}
