package com.task.util;

import com.cloopen.rest.sdk.CCPRestSDK;

import java.util.HashMap;
import java.util.Set;

public class SmsUtil {

    private String serverIP;
    private String serverPort;

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    private String appId;
    private String accountSid;
    private String accountToken;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public CCPRestSDK getSmsUtil(){
        CCPRestSDK client = new CCPRestSDK();
        client.init(serverIP, serverPort);
        client.setAccount(accountSid, accountToken);
        client.setAppId(appId);
        return client;
    }

    public int sendSms(String phone,String code){
        CCPRestSDK restSDK = getSmsUtil();

        HashMap<String, Object> result = null;

        result = restSDK.sendTemplateSMS(phone, "1", new String[]{code,"1"});

        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
            return 0;
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return 1;
        }


    }
}
