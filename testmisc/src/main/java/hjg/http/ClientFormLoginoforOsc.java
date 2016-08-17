package hjg.http;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
 
/**
 * A example that demonstrates how HttpClient APIs can be used to perform
 * form-based logon.
 */
public class ClientFormLoginoforOsc {
 
    public static void main(String[] args) throws Exception {
         
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
 
            HttpPost httpost = new HttpPost("https://192.168.0.117/server.php?model=rpc");
 
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("username", "admin"));
            nvps.add(new BasicNameValuePair("password", "admin"));
            nvps.add(new BasicNameValuePair("command", "hello command"));
 
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
 
            HttpResponse  response = httpclient.execute(httpost);
            HttpEntity entity = response.getEntity();
 
            System.out.println("Login form get: " + response.getStatusLine());
            EntityUtils.consume(entity);
 
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }
}