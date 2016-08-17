package hjg.enctrypt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class TestSec {

	public static void main(String[] args) throws Exception {
		testRSA();
		
	}

	private static void testRSA() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		String me="abcd";
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		KeyPair kp = kpg.generateKeyPair();
		RSAPublicKey rpubk = (RSAPublicKey)kp.getPublic();
		RSAPrivateKey rprik = (RSAPrivateKey)kp.getPrivate();
		Cipher c = Cipher.getInstance("RSA");
		
		c.init(Cipher.ENCRYPT_MODE, rpubk);
		
		byte[] enstr = c.doFinal(me.getBytes());
		String str = new String(enstr);
		System.out.println("明文："+me+" 加密后："+str);
		
		Cipher d = Cipher.getInstance("RSA");
		d.init(Cipher.DECRYPT_MODE, rprik);
		
		System.out.println("解密后："+new String(d.doFinal(enstr)));
	}

	private static void testDES() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		String b ="defghijklmn";
		KeyGenerator keyg = KeyGenerator.getInstance("DES");
		SecretKey key = keyg.generateKey();
		Cipher c = Cipher.getInstance("DES");
		c.init(Cipher.ENCRYPT_MODE, key);
		String enstr = new String(c.doFinal(b.getBytes()));
		System.out.println("字符串："+b+" 加密："+enstr);
		Cipher d = Cipher.getInstance("DES");
		d.init(Cipher.DECRYPT_MODE, key);
		byte[] bs = b.getBytes();
		byte[] dbs = d.doFinal(bs);
		String destr = new String(dbs);
		System.out.println("解密 "+destr);
	}

	private static void testMd5() throws NoSuchAlgorithmException {
		String a="abc";
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte[] bi = a.getBytes();
		md.update(bi);
		
		System.out.println("字符串： "+a+" 摘要："+new String(md.digest()));
	}

}
