package hjg.qiniu;

import java.io.File;
import java.io.InputStream;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class QiniuUtils {

	final static String ak = "gx37fl79RG1QGc0DHddKTTARO2GzbeilG18mui-I";
	final static String sk = "5lLL2wNXdJeD2zeSEZLc8GdQUVW7qVfBA8rCFfs5";
	
	private static void initKey(){
		Config.ACCESS_KEY = ak;
		Config.SECRET_KEY = sk;
	}
	
	private static String getUpToKen() throws AuthException, JSONException{
		initKey();
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "haojg";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        return uptoken;
	}
	
	public static int upFile(String key, String filepath) throws AuthException, JSONException{
		String uptoken = getUpToKen();
        PutExtra extra = new PutExtra();
        PutRet ret = IoApi.putFile(uptoken, key, filepath, extra);
        return ret.getStatusCode();
	}
	public static int upFile(String key, File file) throws AuthException, JSONException{
		String uptoken = getUpToKen();
		PutExtra extra = new PutExtra();
		PutRet ret = IoApi.putFile(uptoken, key, file, extra);
		return ret.getStatusCode();
	}
	public static int upFile(String key, InputStream reader) throws AuthException, JSONException{
		String uptoken = getUpToKen();
		PutExtra extra = new PutExtra();
		PutRet ret = IoApi.Put(uptoken, key, reader, extra);
		return ret.getStatusCode();
	}
	
	public static void main(String[] args) throws Exception {
	}
	
	
}
