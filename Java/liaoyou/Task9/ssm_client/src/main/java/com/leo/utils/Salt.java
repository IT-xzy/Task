package com.leo.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Salt {
	public static String getSalt(){
		SecureRandom secureRandom = null;
		try {
			// 实例化一个伪随机数生成器
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有这个PRNG算法");
		}
		// 定义一个长度为16字节的字节数组(即128位,跟MD5的散列值保持一致)
		// 为了安全,一般盐值长度要大于等于散列值函数输出值长度
		byte[] randomByteArray = new byte[16];
		// 生成指定的128位伪随机数并放入字节数组
		secureRandom.nextBytes(randomByteArray);
		
		// 将字节数组转换为十六进制字符串并返回
		return BytesOrHexString.bytesToHexString(randomByteArray);
	}
}
