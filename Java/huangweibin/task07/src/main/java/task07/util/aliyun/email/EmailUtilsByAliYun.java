package task07.util.aliyun.email;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task07.pojo.UserLogin;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class EmailUtilsByAliYun {

	private static ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("spring/spring-aliyun.xml");

	private static String accessKeyId;
	private static String accessKeySecret;
	//邮件发送者地址
	private static String noreplyAddress;
	private static String notifyAddress;

	// 发信人名称
	private static String fromAlias;
	private static String tagName;


	public static void getSMSVerify(UserLogin userLogin, String code) {
		// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。

		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		// 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
		//try {
		//DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
		//} catch (ClientException e) {
		//e.printStackTrace();
		//}
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		try {
			//request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
			// 邮件发送者地址
			request.setAccountName(noreplyAddress);
			// 发件人名称
			request.setFromAlias(fromAlias);
			request.setAddressType(1);
			// 标签名字
			request.setTagName(tagName);
			// 邮件发送反馈
			request.setReplyToAddress(true);
			// 发送的目的邮箱地址
			request.setToAddress(userLogin.getEmail());
			// 发送的目的邮箱的头衔
			request.setSubject(userLogin.getName());
			request.setHtmlBody("您好！您正在申请邮箱注册，验证码为：" + code + ",5分钟内有效！");
			// hint 此处可能会抛出异常，注意catch
			SingleSendMailResponse httpResponse = client.getAcsResponse(request);

		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}


	public static String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		EmailUtilsByAliYun.accessKeyId = accessKeyId;
	}

	public static String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		EmailUtilsByAliYun.accessKeySecret = accessKeySecret;
	}

	public static String getNoreplyAddress() {
		return noreplyAddress;
	}

	public void setNoreplyAddress(String noreplyAddress) {
		EmailUtilsByAliYun.noreplyAddress = noreplyAddress;
	}

	public static String getNotifyAddress() {
		return notifyAddress;
	}

	public void setNotifyAddress(String notifyAddress) {
		EmailUtilsByAliYun.notifyAddress = notifyAddress;
	}

	public static String getFromAlias() {
		return fromAlias;
	}

	public void setFromAlias(String fromAlias) {
		EmailUtilsByAliYun.fromAlias = fromAlias;
	}

	public static String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		EmailUtilsByAliYun.tagName = tagName;
	}
}