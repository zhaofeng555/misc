package hjg.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
public class GetURLContent {
	public static void main(String[] args) {
 
		URL url;
 
		try {
			// get URL content
			url = new URL("http://www.baidu.com");
			URLConnection conn = url.openConnection();
 
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 
			String inputLine;
 
			//save to this filename
			String fileName = "resource/test.html";
			File file = new File(fileName);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
 
			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
				System.out.println(inputLine);
			}
 
			bw.close();
			br.close();
 
			System.out.println("Done");
 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}