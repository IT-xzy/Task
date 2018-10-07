package com.leo.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.io.IOException;
import java.util.Properties;

/**
 * @Belong: 邮件
 * @Description: 阿里云邮件服务工具类
 * @Author: jk-leo
 * @Date: 2018/9/19 15:36
 */
public class AliEmailUtil {
	
	static Properties properties = new Properties();
	
	// 用静态代码块来初始化
	static{
		try {
			properties.load(ImageUtil.class.getResourceAsStream("/aliEmail.properties"));
		} catch (IOException e) {
			System.out.println("读取配置文件失败");
		}
	}
	
	private static String regionId = properties.getProperty("regionId");
	private static String accessKeyId = properties.getProperty("accessKeyId");
	private static String secret = properties.getProperty("secret");
	
	/**
	 * @Desciption: 调用阿里云邮件服务接口发送邮件并返回生成的验证码
	 * @Param: email
	 * @Return: emailCode
	 * @Author: jk-leo
	 * @Date: 2018/9/19 21:54
	 */
	public static String setEmail(String email){
		
		String emailCode = VerificationCode.getSixNumberCode();
		
		IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,secret);
		
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		
		// 操作接口名，必选
		request.setActionName("SingleSendMail");
		// 发信地址，必选
		request.setAccountName("mylove@mail.superleo.top");
		// 发信人昵称，可选
		request.setFromAlias("leo");
		// 1为发信地址，0为随机账号，必选
		request.setAddressType(1);
		// 确认回信地址验证通过，必须
		request.setReplyToAddress(true);
		// 目标地址，可以多个，逗号分隔，必选
		request.setToAddress(email);
		// 邮件主题，可选
		request.setSubject("hello, ali email");
		// 邮件HTML正文，限制28K，可选
		request.setHtmlBody("<h3>我的网站:<a href='http://superleo.top/'>http://superleo.top</a></h3>" +
				"<h5>验证码："+emailCode+"</h5>");
		// 邮件text正文，限制28K，可选
		// request.setTextBody("xxx");
		
		try {
			SingleSendMailResponse httpResponse = client.getAcsResponse(request);
			System.out.println("EnvId:"+httpResponse.getEnvId()+"  RequestId:"+httpResponse.getRequestId());
			return emailCode;
		} catch (ClientException e) {
			e.printStackTrace();
			System.out.println("邮件发送失败");
			return null;
		}
	}
}
