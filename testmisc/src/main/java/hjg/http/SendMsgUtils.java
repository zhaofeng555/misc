package hjg.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class SendMsgUtils {

	Map<String, Object> params = new HashMap<String, Object>();
	{
		params.put("debug", true);
		params.put("host", "sdk229ws.eucp.b2m.cn");
		params.put("port", 8080);
		params.put("regist_info_path", "/sdkproxy/registdetailinfo.action");
		params.put("regist_path", "/sdkproxy/regist.action");
		params.put("send_sms_path", "/sdkproxy/sendsms.action");
		params.put("cdkey", "9SDK-EMY-0229-JDSQK");
		params.put("password", "494404");
		params.put("ename", "北京中文在线文化传媒有限公司");
		params.put("linkman", "李佾霖");
		params.put("phonenum", "010-51668567");
		params.put("mobile", "13581828362");
		params.put("email", "liyl@chineseall.com");
		params.put("fax", "86-10-84195550");
		params.put("address", "北京市东城区安定门东大街28号雍和大厦E座5层505号");
		params.put("postcode", "100007");
		params.put("addserial", "");
	}
	public void init(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("cdkey", "9SDK-EMY-0229-JDSQK");
		params.put("password", "494404");
		params.put("ename", "北京中文在线文化传媒有限公司");
		params.put("linkman", "李佾霖");
		params.put("phonenum", "010-51668567");
		params.put("mobile", "13581828362");
		params.put("email", "liyl@chineseall.com");
		params.put("fax", "86-10-84195550");
		params.put("address", "北京市东城区安定门东大街28号雍和大厦E座5层505号");
		params.put("postcode", "100007");
		
		String url="http://sdk229ws.eucp.b2m.cn:8080/sdkproxy/registdetailinfo.action";
		String rep = sendPostRequest(url, params);
		System.out.println("init .......");
		System.out.println(rep);
	}
	
	public void sendMsg(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("cdkey", "9SDK-EMY-0229-JDSQK");
		params.put("password", "494404");
		params.put("phone", "13693537055");
		params.put("message", msgTemplate+123456);
		
		String url = "http://sdk229ws.eucp.b2m.cn:8080/sdkproxy/sendsms.action";
		String rep = sendPostRequest(url, params);
		System.out.println("send ............ ");
		System.out.println(rep);
	}
	
	static String msgTemplate="【汤圆创作】这是您的验证码：";
	public static void main(String[] args) {
		SendMsgUtils s = new SendMsgUtils();
		s.init();
//		s.sendMsg();
	}

	
	public static String sendPostRequest(String reqURL,  Map<String, String> params){
        String responseContent = null;
        HttpClient httpClient = new DefaultHttpClient();
         
        HttpPost httpPost = new HttpPost("http://www.baidu.com");
        
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
        try{
    		//set params
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for(Map.Entry<String,String> entry : params.entrySet()){
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            StringEntity se =  new StringEntity(URLEncodedUtils.format(formParams,"UTF-8"));
            
            //set headers
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
    		httpPost.setHeader("Host", "sdk229ws.eucp.b2m.cn:8080");
    		httpPost.setHeader("Connection", "Keep-Alive");
    		httpPost.setHeader("Accept", "application/xml, text/xml, */*; q=0.01");
    		httpPost.setHeader("Accept-Language","zh-cn");
    		httpPost.setHeader("Cache-Control", "no-cache");
    		httpPost.setHeader("Referer", "http://ihani.com");
//    		httpPost.setHeader("Content-Length", se.getContentLength());
            httpPost.setEntity(se);
             
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (null != entity) {
    			System.out.println("contentEncoding = "+entity.getContentEncoding());
                responseContent = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }else{
            	System.out.println("返回失败。。。。");
            }
        }catch(Exception e){
        	e.printStackTrace();
//            System.out.println("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下"+e.getMessage());
        }finally{
//            httpClient.getConnectionManager().shutdown();
        }
        return responseContent;
    }
	
}
