package hjg.enctrypt;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class ComputopTest {

	public static void main(String args[]) throws Exception {

		String macKey = "hello";
		String macData = "world";
		System.out.println("MACDATA:" + macData);

		String checksum = getSign(macKey, macData);

		System.out.println(checksum);
		System.out.println(checksum.length());
//		!CTbwBewn9igswDmeBXoj4Q==?WyJoZWxsbyIsICJ3b3JsZCJd
		
		System.out.println("CTbwBewn9igswDmeBXoj4Q==".length());
		
	}

	private static String getSign(String macKey, String macData)throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		// get the bytes of the hmac key and data string
		byte[] secretByte = macKey.getBytes("UTF-8");
		byte[] dataBytes = macData.getBytes("UTF-8");
		SecretKey secret = new SecretKeySpec(secretByte, "HMACSHA256");
		mac.init(secret);
		byte[] doFinal = mac.doFinal(dataBytes);
		byte[] hexB = new Hex().encode(doFinal);
		return new String(hexB);
	}
}