package com.suger.util;

//import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Set;

/**
 * 容联短信的工具类
 * @author suger
 * @date 2018/12/15 17:15
 */
public class SMS {

    private String serverIp;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appId;

    public SMS() {
    }

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
     * @param msgCode 验证码
     * @return 发送短信成功与否
     */

    public String sendMessage(String telephone,String msgCode){


        HashMap<String, Object> result = null;

        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();


        //*初始化服务器地址和端口
        //*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883")
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883")

        restAPI.init(serverIp,serverPort);

        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN

        restAPI.setAccount(accountSid, accountToken);


        //*初始化应用ID
        //*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID
        //*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID
        restAPI.setAppId(appId);

        //*调用发送模板短信的接口发送短信
        //*参数顺序说明：
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”
        //*第三个参数是要替换的内容数组。
        //************************************************************************************************

        //**************************************举例说明***************************************************
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于10分钟内正确输入
        //***************************************************************************************************
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
            return "true";
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return "false";
        }

    }

}
