package com.mvc.third_PartyUtil;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;

public class SendPhone {
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

	public HashMap<String, Object> setPhone(String phoneNumber, String verification_code){
		String serverIP = this.serverIP;
		String serverPort = this.serverPort;
		String accounSid = this.accounSid;
		String accountToken = this.accountToken;
		String AppID = this.AppID;
		String templateID = this.templateID;
		String NeedTime = this.NeedTime;

		HashMap<String, Object> result = null;

		//初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

		restAPI.init(serverIP, serverPort);

		restAPI.setAccount(accounSid, accountToken);

		restAPI.setAppId(AppID);

		//******************************注释****************************************************************
		//*调用发送模板短信的接口发送短信                                                                  *
		//*参数顺序说明：                                                                                  *
		//*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
		//*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
		//*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		//*第三个参数是要替换的内容数组。
		//**************************************举例说明***********************************************************************
		//*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
		//*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});
		//*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
		result = restAPI.sendTemplateSMS(phoneNumber, templateID, new String[]{verification_code,NeedTime});

		return result;
	}
}
