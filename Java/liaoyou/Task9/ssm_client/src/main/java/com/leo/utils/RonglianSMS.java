package com.leo.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

/**
 * @Belong: task7
 * @Description: 容联sms工具类：生成六位数验证码并通过容联给用户发送验证短信
 * @Author: jk-leo
 * @Date: 2018/9/10 14:35
 */
public class RonglianSMS {
	
	static Properties properties = new Properties();
	
	// 用静态代码块来初始化
	static{
		try {
			properties.load(ImageUtil.class.getResourceAsStream("/RonglianSMS.properties"));
		} catch (IOException e1) {
			System.out.println("读取配置文件失败");
		}
	}
	
	private static String serverIP = properties.getProperty("serverIP");
	private static String serverPort = properties.getProperty("serverPort");
	private static String accountSid = properties.getProperty("accountSid");
	private static String accountToken = properties.getProperty("accountToken");
	private static String appId = properties.getProperty("appId");

	/**
	 * @Desciption: 调用联容短信接口给用户发送短信
	 * @Param: String phoneNumber
	 * @Return: String phoneCode
	 * @Author: jk-leo
	 * @Date: 2018/9/10 15:33
	 */
	public static String setSMS(String phoneNumber){

		HashMap<String, Object> result = null;
		String phoneCode = VerificationCode.getSixNumberCode();

		// 初始化SDK
		CCPRestSmsSDK restSmsSDK = new CCPRestSmsSDK();
		// 初始化服务器地址和端口(采用沙盒环境免费)
		restSmsSDK.init(serverIP,serverPort);
		// 初始化主账号和主账号令牌
		restSmsSDK.setAccount(accountSid,accountToken);
		// 初始化应用ID
		restSmsSDK.setAppId(appId);
		// 调用发送模板短信的接口发送短信
		result = restSmsSDK.sendTemplateSMS(phoneNumber,"1",new String[]{phoneCode,"5"});

		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}

			return phoneCode;
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			return null;
		}
	}
}
