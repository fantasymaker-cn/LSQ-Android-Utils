package cn.fantasymaker.lsqandroidutils.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import android.util.Base64;

/**
 * Convenience utils for encoding and decoding. functions:<br>
 * - Base64 encode and decode<br>
 * - URL encode and decode
 * @author Li Shaoqing
 */
public class EncodeUtil {
	
	private EncodeUtil() throws InstantiationException{
		throw new InstantiationException("Instantiation is not allowed! Use static methods only!");
	}

	/**
	 * base64 encode
	 * @param plainString string to be encoded
	 * @return encoded string
	 */
	public static String base64Encode(String plainString) {
		if(plainString == null){
			return null;
		}
		byte[] encode = Base64.encode(plainString.getBytes(), Base64.DEFAULT);
		return new String(encode);
	}

	/**
	 * base64 decode
	 * @param encodedString encoded string to be decoded
	 * @return decoded string
	 */
	public static String base64Decode(String encodedString) {
		if(encodedString == null){
			return null;
		}
		byte[] decode = Base64.decode(encodedString.getBytes(), Base64.DEFAULT);
		return new String(decode);
	}
	
	/**
	 * URL encode
	 * @param plainString string to be encoded
	 * @param charsetName charset name for encoding
	 * @return encoded url string
	 * @throws UnsupportedEncodingException
	 */
	public static String urlEncode(String plainString, String charsetName) throws UnsupportedEncodingException{
		return plainString == null? null : URLEncoder.encode(plainString, charsetName);
	}
	
	/**
	 * URL decode
	 * @param encodedString encoded string to be decoded
	 * @param charsetName charset name for decoding
	 * @return decoded url string
	 * @throws UnsupportedEncodingException
	 */
	public static String urlDecode(String encodedString, String charsetName) throws UnsupportedEncodingException{
		return encodedString == null? null : URLDecoder.decode(encodedString, charsetName);
	}
}
