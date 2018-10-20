package com.leo.utils;

import java.util.Random;

/**
 * @Belong: task7
 * @Description: 验证码生成工具类
 * @Author: jk-leo
 * @Date: 2018/9/19 15:52
 */
public class VerificationCode {
	
	/**
	 * @Desciption: 生成六位纯数字验证码并返回
	 * @Param: void
	 * @Return: String phoneCode
	 * @Author: jk-leo
	 * @Date: 2018/9/10 15:31
	 */
	public static String getSixNumberCode(){
		
		// 如果再加上一些字母，就可以生成普通的验证码
		String source = "0123456789";
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i=0; i<6; i++){
			stringBuffer.append(source.charAt(random.nextInt(9)));
		}
		return stringBuffer.toString();
	}
	
	public static int getOneNumber(){
		Random random = new Random();
		int number = random.nextInt(2);
		return number;
	}
	
}
