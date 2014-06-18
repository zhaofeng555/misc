package hjg.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadHTTP {

	public static void main(String[] args) throws Exception {
		String content = readURLContent("http://www.baidu.com");
		writeFile(content);
	}

	public static String readURLContent(String url) {
		StringBuilder sb = new StringBuilder();
		try {
			URL myurl = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(myurl.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				sb.append(strTemp);
				System.out.println(strTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void writeFile(String content) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("resource/httpcontent.txt", true));
			out.write(content);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
