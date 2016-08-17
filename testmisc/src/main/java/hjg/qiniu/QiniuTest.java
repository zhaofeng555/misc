package hjg.qiniu;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class QiniuTest {
	final static String ak = "EjRSYSXQDm-ihlBoF9vG4vHPK0dSxwLYDnwxMgUv";
	final static String sk = "7OtL5GSXUtlygYEUmxU2j5fXoWcWpvWz0n1mor6z";
	final static String bucketName = "hnb-img0";
	
	public static void init() throws AuthException, JSONException {
		Config.ACCESS_KEY = ak;
		Config.SECRET_KEY = sk;
		
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        
        PutExtra extra = new PutExtra();
        String key = "touxiang_user";
        String localFile = "d:/ko.jpg";
        PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);
        System.out.println(ret.getStatusCode());
        System.out.println(ret.getResponse());
        
	}
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	
}
