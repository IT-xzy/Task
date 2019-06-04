package com.jnshu.pojo.tool;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

/**
 * @author pipiretrak
 * @date 2019/5/22 - 2:59
 */
public class SMS {
    private String serverIp;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appId;

    public SMS(String serverIp, String serverPort, String accountSid, String accountToken, String appId) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.appId = appId;
    }

    /**
     * 调用容联短信API
     * @param telephone 电话
     * @return 发送短信成功与否
     */
    public String sendMessage(String telephone,String msgCode){
        HashMap<String, Object> result = null;
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        //*初始化服务器地址和端口
        restAPI.init(serverIp,serverPort);
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN
        restAPI.setAccount(accountSid, accountToken);
        //*初始化应用ID
        restAPI.setAppId(appId);
        //*调用发送模板短信的接口发送短信
        result = restAPI.sendTemplateSMS(telephone,"1" ,new String[]{msgCode,"10"});

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
        return String.valueOf(result.get("statusCode"));
    }
}
