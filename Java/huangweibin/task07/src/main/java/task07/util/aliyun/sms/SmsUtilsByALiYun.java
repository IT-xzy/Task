package task07.util.aliyun.sms;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
public class SmsUtilsByALiYun {

	// 产品名称:云通信短信API产品,开发者无需替换
	private static String product;
	// 产品域名,开发者无需替换
	private static String domain;

	// TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
	private static String accessKeyId;     // TODO 改这里
	private static String accessKeySecret; // TODO 改这里

	// 用于生成随机代码
	private static int newcode;

	// 短信签名
	private static String signName;
	// 短信模板
	private static String templateCode;


	public static SendSmsResponse sendSms(String telephone, String code) throws ClientException {


		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

		System.out.println(accessKeyId + "1" + accessKeySecret + "2" + product);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号
		request.setPhoneNumbers(telephone);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(signName); // TODO 改这里
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(templateCode);  // TODO 改这里
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,您的验证码为${code}"时,此处的值为
		request.setTemplateParam("{\"code\":\"" + code + "\"}");

		// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");

		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");

		// hint 此处可能会抛出异常，注意catch
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			System.out.println("短信发送成功！");
		} else {
			System.out.println("短信发送失败！");
		}


		return sendSmsResponse;
	}


	// public static void main(String[] args) throws Exception {
	// 	setNewcode();
	// 	String code = Integer.toString(getNewcode());
	// 	// 填写你需要测试的手机号码
	// 	SendSmsResponse sendSms =sendSms("13537288757",code);
	// 	System.out.println("短信接口返回的数据----------------");
	// 	System.out.println("Code=" + sendSms.getCode());
	// 	System.out.println("Message=" + sendSms.getMessage());
	// 	System.out.println("RequestId=" + sendSms.getRequestId());
	// 	System.out.println("BizId=" + sendSms.getBizId());
	//
	// }


	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		SmsUtilsByALiYun.product = product;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		SmsUtilsByALiYun.domain = domain;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		SmsUtilsByALiYun.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		SmsUtilsByALiYun.accessKeySecret = accessKeySecret;
	}


	public static int getNewcode() {
		return newcode;
	}

	public static void setNewcode() {
		newcode = (int) (Math.random() * 9999) + 100;  //每次调用生成一次四位数的随机数
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		SmsUtilsByALiYun.signName = signName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		SmsUtilsByALiYun.templateCode = templateCode;
	}
}
