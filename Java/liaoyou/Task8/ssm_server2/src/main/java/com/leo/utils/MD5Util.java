package com.leo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String getPasswordHash(String password,String salt){
		
		String hexString = null;
		String pwdSalt = salt+password;
		// 创建MD5对象
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 计算散列值并以字节数组形式返回
			byte[] md5 = messageDigest.digest(pwdSalt.getBytes());
			// 将字节数组转换为十六进制字符串
			hexString = BytesOrHexString.bytesToHexString(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("创建MD5对象失败");
		}
		return hexString;
	}
}
