package hjg.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author hjg
 * @version 创建时间：2010-10-19下午10:00:08
 * 
 **/
public class JavaDirectRead {
	static Log log = LogFactory.getLog(JavaDirectRead.class);

	public static void main(String[] args) throws Exception {
		String title = "这是标题";
		String url_str = "http://www.baidu.com/";
		readJsp(url_str);
		readAction(url_str);
	}

	public static void readJsp(String url_str) throws Exception {
		
		URL url = new URL(url_str);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		int code = connection.getResponseCode();// 若不调用此代码，则不能调用成功
		log.info("code========" + code);
	}

	public static void readAction(String url_str) throws Exception {

		// java如何通过url调用远程接口并读取返回信息?
//		String ticket = "";// 登录凭证
//		String url_str = "http://www.sina.com.cn?ticket=";// 获取用户认证的帐号URL
//		String ticket_url = url_str + ticket;
		URL url = new URL(url_str);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();

		int code = connection.getResponseCode();
		if (code == 404) {
			throw new Exception("认证无效，找不到此次认证的会话信息！");
		}
		if (code == 500) {
			throw new Exception("认证服务器发生内部错误！");
		}
		if (code != 200) {
			throw new Exception("发生其它错误，认证服务器返回 " + code);
		}
		InputStream is = connection.getInputStream();
		byte[] response = new byte[is.available()];
		is.read(response);
		is.close();
		if (response == null || response.length == 0) {
			throw new Exception("认证无效，找不到此次认证的会话信息！");
		}
		String userId = new String(response, "GBK");
		System.out.println(userId);

	}

	// public static void readUrl(){
	// URL u = new URL( url );
	// URLConnection uc = u.openConnection();
	// HttpURLConnection httpUC = (HttpURLConnection)uc;
	// // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,
	// 默认情况下是false;
	// httpUC.setDoOutput( true );
	// // Post 请求不能使用缓存
	// httpUC.setUseCaches(false);
	//
	// // 增加更多的请求头信息
	// Iterator<String> it = requestHeads.keySet().iterator();
	// while( it.hasNext() ){
	// String name = it.next(); String value = requestHeads.get( name );
	// httpUC.addRequestProperty( name , value );
	// }
	//
	// // 设定传送的内容类型是可序列化的java对象
	// // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
	// httpUC.setRequestProperty("Content-type",
	// "application/x-java-serialized-object");
	// // 设定请求的方法为"POST"，默认是GET
	// httpUC.setRequestMethod("POST");
	//
	// // 连接，上面的配置必须要在connect之前完成. 不知道是否要连接池??? rhwang 2009-02-27
	// httpUC.connect();
	//
	// }

}
