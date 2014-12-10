package hjg.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class HttpClientUtils {
	private static String URL = "http://www.baidu.com";

	public static void configHttpPost() throws Exception {
		HttpPost post = new HttpPost(URL);

		// (2) 使用HttpClient发送get请求，获得返回结果HttpResponse
		HttpClient http = new DefaultHttpClient();
		HttpResponse response = http.execute(post);

		// (3) 读取返回结果
		if (response.getStatusLine().getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();
			// (4) 从输入流读取网页字符串内容
			System.out.println(entity.getContentType());
			System.out.println(entity.getContentEncoding());
			System.out.println(entity.getContentLength());
			InputStream in = entity.getContent();
			readResponse(in);
		}
	}

	public static void readResponse(InputStream in) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void setParams(HttpPost post, List<NameValuePair> params)
			throws Exception {
		post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
	}

	public static void setParams(HttpPost post, Map<String, String> paramMap)
			throws UnsupportedEncodingException {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> en : paramMap.entrySet()) {
			params.add(new BasicNameValuePair(en.getKey(), en.getValue()));
		}
		post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
	}

	public static void setHeader(HttpPost post, Map<String, String> headerMap) {
		for (Map.Entry<String, String> en : headerMap.entrySet()) {
			post.setHeader(en.getKey(), en.getValue());
		}
	}
}