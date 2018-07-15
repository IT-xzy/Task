package com.mvc.springUtil;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;

public class SendPhoneTemplate {

	private String serverIP;
	private String serverPort;
	private String accounSid;
	private String accountToken;
	private String AppID;
	private String templateID;
	private String NeedTime;

	public String getServerIP() {
		return this.serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public String getServerPort() {
		return this.serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getAccounSid() {
		return this.accounSid;
	}

	public void setAccounSid(String accounSid) {
		this.accounSid = accounSid;
	}

	public String getAccountToken() {
		return this.accountToken;
	}

	public void setAccountToken(String accountToken) {
		this.accountToken = accountToken;
	}

	public String getAppID() {
		return this.AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}

	public String getTemplateID() {
		return this.templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getNeedTime() {
		return this.NeedTime;
	}

	public void setNeedTime(String needTime) {
		NeedTime = needTime;
	}

	/*private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringOtherAPI.xml");*/

	public HashMap<String, Object> setPhone(String A, String B){

		/*SendPhoneTemplate sendPhoneTemplate =(SendPhoneTemplate) context.getBean("PhoneMessage");*/

		HashMap<String, Object> result = null;

		//初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

		String serverIP1 = this.serverIP;
		String serverPort1 = this.serverPort;
		String accounSid1 = this.accounSid;
		String accountToken1 = this.accountToken;
		String AppID1 = this.AppID;
		String templateID1 = this.templateID;
		String NeedTime1 = this.NeedTime;


		restAPI.init(serverIP1, serverPort1);

		restAPI.setAccount(accounSid1, accountToken1);

		restAPI.setAppId(AppID1);


		//******************************注释****************************************************************
		//*调用发送模板短信的接口发送短信                                                                  *
		//*参数顺序说明：                                                                                  *
		//*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
		//*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
		//*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		//*第三个参数是要替换的内容数组。																														       *
		//**************************************************************************************************

		//**************************************举例说明***********************************************************************
		//*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
		//*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
		//*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
		//*********************************************************************************************************************
		result = restAPI.sendTemplateSMS(A, templateID1, new String[]{B,NeedTime1});

		/*if ("000000".equals(result.get("statusCode"))) {
			//正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				System.out.println(key + " = " + object);
			}
		} else {
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}*/
		return result;
	}
}
