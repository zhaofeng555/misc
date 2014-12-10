package hjg.enctrypt;


import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {
	public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

	public static final int SALT_BYTE_SIZE = 24;
	public static final int HASH_BYTE_SIZE = 24;
	public static final int PBKDF2_ITERATIONS = 8;

	public static final int ITERATION_INDEX = 0;
	public static final int SALT_INDEX = 1;
	public static final int PBKDF2_INDEX = 2;

	public static String createHash(String password)throws NoSuchAlgorithmException, InvalidKeySpecException {
		return createHash(password.toCharArray());
	}

	public static String createHash(char[] password)throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] salt = getRandomSalt();
		byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
		return PBKDF2_ITERATIONS + ":" + toHex(salt) + ":" + toHex(hash);
	}

	public static String getRandomSaltStr(){
		byte[] salt = getRandomSalt();
		return toHex(salt);
	}
	
	public static byte[] getRandomSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_BYTE_SIZE];
		random.nextBytes(salt);
		return salt;
	}
	
	public static boolean validatePassword(String password, String correctHash)throws NoSuchAlgorithmException, InvalidKeySpecException {
		return validatePassword(password.toCharArray(), correctHash);
	}

	public static boolean validatePassword(char[] password, String correctHash)throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] params = correctHash.split(":");
		int iterations = Integer.parseInt(params[ITERATION_INDEX]);
		byte[] salt = fromHex(params[SALT_INDEX]);
		byte[] hash = fromHex(params[PBKDF2_INDEX]);
		byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
		return slowEquals(hash, testHash);
	}

	private static boolean slowEquals(byte[] a, byte[] b) {
		int diff = a.length ^ b.length;
		for (int i = 0; i < a.length && i < b.length; i++)
			diff |= a[i] ^ b[i];
		return diff == 0;
	}

	public static byte[] pbkdf2(char[] password, byte[] salt, int iterations,int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
		return skf.generateSecret(spec).getEncoded();
	}
	public static String pbkdf2(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String enPwd = toHex(pbkdf2(password.toCharArray(), salt.getBytes(), PBKDF2_ITERATIONS, HASH_BYTE_SIZE));
		return enPwd;
	}

	public static byte[] fromHex(String hex) {
		byte[] binary = new byte[hex.length() / 2];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return binary;
	}

	public static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

	public static void main(String[] args) throws Exception {
		int i = 1;
		String password = "hello"+i ;
//		String enPass = createHash(password);
		
		System.out.println(getRandomSaltStr());
		System.out.println(getRandomSaltStr().length());
		
		byte[] bs = pbkdf2(password.toCharArray(), password.getBytes(), PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
		// format iterations:salt:hash
		String result = PBKDF2_ITERATIONS + ":" + toHex(bs) + ":" + toHex(password.getBytes());
		System.out.println(result);
		System.out.println("8:4435e345def574d203610bd3fce1b4edca1b60d12fe7e618:68656c6c6f31");
	}
}