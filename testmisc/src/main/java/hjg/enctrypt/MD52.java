package hjg.enctrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hjg
 * @version 创建时间：2010-4-29下午07:56:56 类说明
 * 
 **/
public class MD52 {

	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
		}
		return sb.toString();
	}

	public static String md5 (String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); //想用SHA加密的话就把MD5换成SHA吧
//            System.out.println(message.getBytes("CP1252"));
            return hex (md.digest(message.getBytes()));
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        return null;
    }
	
	

	public static void main(String[] args) {
		System.out.println(md5("123456"));
	}

}
