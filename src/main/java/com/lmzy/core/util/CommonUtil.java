package com.lmzy.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CommonUtil {
	/**
	 * 生成随机字符串。
	 * @return
	 */
	public static String getUuid() {
		String code = "";
		UUID uuid = UUID.randomUUID();
		code = uuid.toString().replaceAll("-", "");
		return code;
	}
	   public final static String MD5_SHA(String s) {  
	       char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
	               'a', 'b', 'c', 'd', 'e', 'f' };  
	       try {  
	           byte[] strTemp = s.getBytes();  
	           //如果输入“SHA”，就是实现SHA加密。  
	           MessageDigest mdTemp = MessageDigest.getInstance("MD5");   
	           mdTemp.update(strTemp);  
	           byte[] md = mdTemp.digest();  
	           int j = md.length;  
//	           char str[] = new char[j * 2];  
	           StringBuilder stringbuilder = new StringBuilder();
	           int k = 0;  
	           for (int i = 0; i < j; i++) {  
	               byte byte0 = md[i];
	               stringbuilder.append(hexDigits[byte0 >>> 4 & 0xf]);
//	               str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
	               stringbuilder.append(hexDigits[byte0 & 0xf]);
//	               str[k++] = hexDigits[byte0 & 0xf];  
	           }  
	           return stringbuilder.toString();  
	       } catch (Exception e) {  
	           return null;  
	       }  
	   }  

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		try {
			System.out.println(PaySign.EncoderByMd5(uuid.toString()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
