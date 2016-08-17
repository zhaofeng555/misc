//package hjg.https;
//
//import org.apache.http.client.HttpClient;
//
//public class Main {
//	public static void main(String[] args) {
//		HttpClient http = new HttpClient();
//		String url = "https://payment.cib.com.cn/payment/api/rest";
//		Protocol myhttps = new Protocol("https",
//				new MySSLProtocolSocketFactory(), 443);
//		Protocol.registerProtocol("https", myhttps);
//		PostMethod post = new PostMethod(url);
//	}
//}
