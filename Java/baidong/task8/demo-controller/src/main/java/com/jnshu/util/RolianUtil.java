package com.jnshu.util;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;


public class RolianUtil {
    public String serverIP;
    public String serverPort;
    public String accountSid;
    public String accountToken;
    public String appId;
    public String templateId;
    public String time;

    public RolianUtil(String serverIP, String serverPort, String accountSid, String accountToken, String appId,String templateId, String time) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.appId = appId;
        this.templateId = templateId;
        this.time = time;
    }

    public void rolian(String to,String code) {

        HashMap<String, Object> result = null;

		//初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

//		初始化服务器地址和代码
		restAPI.init(serverIP, serverPort);

//		初始化主账号和主账号令牌
		restAPI.setAccount(accountSid, accountToken);



		//*初始化应用ID                                                                 *

		restAPI.setAppId(appId);



		//*调用发送模板短信的接口发送短信                                                                  *

		result = restAPI.sendTemplateSMS(to,templateId ,new String[]{code,time});

		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
    }
}
