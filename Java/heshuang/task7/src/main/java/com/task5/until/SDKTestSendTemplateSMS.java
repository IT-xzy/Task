package com.task5.until;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.task5.FAQ.Sms;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class SDKTestSendTemplateSMS {
    public static String sendTemplateSMS(String phoneNumber,String code) {
//        配置短信bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Sms sms = (Sms) applicationContext.getBean("sms");

        HashMap<String, Object> result = null;
        String msgStatus;
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

        //******************************注释*********************************************
        //*初始化服务器地址和端口                                                       *
        //*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
        //*******************************************************************************
        restAPI.init(sms.getServerIP(), "8883");

        //******************************注释*********************************************
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        //*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
        //*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
        //*******************************************************************************
        restAPI.setAccount(sms.getAccountSid(), sms.getAccountToken());

        // 请使用管理控制台中已创建应用的APPID。
        restAPI.setAppId(sms.getAPPID());

        result = restAPI.sendTemplateSMS(phoneNumber,sms.getTemplateId() ,new String[]{code,"1"});

        MemcachedUtils.set("code",code,new Date(60*1000));
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
            msgStatus = "true";
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            msgStatus = "failure";
        }
        return msgStatus;
    }
}
