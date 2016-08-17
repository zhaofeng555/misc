package hjg.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class ReadHTTP {
	public static String doGet(){
		
//		HttpGet httpGet = new HttpGet("http://localhost:8081/ihaniforum/feedback/listener");
		HttpGet httpGet = new HttpGet("http://localhost:8989");
		HttpParams hp = httpGet.getParams();
		hp.getParameter("true");
		//hp.
		//httpGet.setp
		HttpClient hc = new DefaultHttpClient();
		try {
			HttpResponse ht = hc.execute(httpGet);
			if(ht.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity he = ht.getEntity();
				InputStream is = he.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String response = "";
				String readLine = null;
				while((readLine =br.readLine()) != null){
					//response = br.readLine();
					response = response + readLine;
				}
				is.close();
				br.close();
				
				//String str = EntityUtils.toString(he);
				System.out.println("========="+response);
				return response;
			}else{
				return "error";
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception";
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
//		String content = readURLContent("http://www.baidu.com");
//		String content = readURLContent("http://localhost:9999");
//		writeFile(content);
		
		doGet();
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
