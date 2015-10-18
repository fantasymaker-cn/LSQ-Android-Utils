package cn.fantasymaker.lsqandroidutils.utils;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Convenience util for encryption. function:<br>
 * - SHA-1 encryption<br>
 * - MD5 encryption<br>
 * - get MD5 value of input stream
 * @author Li Shaoqing
 */
public class EncryptionUtil {
	
	private EncryptionUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}

	private static final int SALT = 888;

	/**
	 * SHA-1 encryption
	 * @param plainString String to be encrypted
	 * @param saltMode true: add salt; false: standard
	 * @return encrypted string
	 */
	public static String sha1Encrypt(String plainString, boolean saltMode) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] buffer = digest.digest(plainString.getBytes());
			StringBuffer sb = new StringBuffer();
			for (byte b : buffer) {
				int result = b & 0xff;
				String hex = "";
				if (saltMode) {
					// not standard sha-1, add salt to prevent decryption
					hex = Integer.toHexString(result) + SALT;
				} else {
					// standard sha-1 encryption mode, can be decrypted
					hex = Integer.toHexString(result);
				}
				// if hex contains only 1 charactor, add an '0' in front of it
				if (hex.length() == 1) {
					hex = 0 + hex;
				}
				//concat hex
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * MD5 encryption
	 * @param plainString String to be encrypted
	 * @param saltMode true: add salt; false: standard
	 * @return encrypted string
	 */
	public static String md5Encrypt(String plainString, boolean saltMode) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] buffer = digest.digest(plainString.getBytes());
			StringBuffer sb = new StringBuffer();
			for (byte b : buffer) {
				int result = b & 0xff;
				String hex = "";
				if (saltMode) {
					// not standard MD5, add salt to prevent decryption
					hex = Integer.toHexString(result) + SALT;
				} else {
					// standard MD5 encryption mode, can be decrypted
					hex = Integer.toHexString(result);
				}
				// if hex contains only 1 charactor, add an '0' in front of it
				if (hex.length() == 1) {
					hex = 0 + hex;
				}
				//concat hex
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * get MD5 string of an input stream. Normally use for checking file
	 * @param in InputStream
	 * @param saltMode true: add salt; false: standard
	 * @return MD5 string
	 */
	public static String getMD5(InputStream in, boolean saltMode) {
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			byte[] bytes = new byte[8192];  //8Mb buffer
			int byteCount;
			while ((byteCount = in.read(bytes)) > 0) {
				digester.update(bytes, 0, byteCount);
			}
			byte[] digest = digester.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				int result = b & 0xff;
				String hex = "";
				if(saltMode){
					hex = Integer.toHexString(result) + SALT;
				}else{
					hex = Integer.toHexString(result);
				}
				if (hex.length() == 1) {
					hex = 0 + hex;
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * simple encrytion
	 * @param plainString string to be encryted
	 * @param key int value to be a key for encryption
	 * @return encryted string
	 */
	public static String simpleEncrypt(String plainString, int key) {
		byte[] bytes = plainString.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] ^= key;
		}
		return new String(bytes);
	}
	
	/**
	 * decrypt from simple encrypted string
	 * @param encString encrypted string to be decrypted
	 * @param key int value to be a key for decryption
	 * @return decrypted string
	 */
	public static String simpleDecrypt(String encString, int key) {
		//process is same, re-do once
		return simpleEncrypt(encString, key);
	}
}
