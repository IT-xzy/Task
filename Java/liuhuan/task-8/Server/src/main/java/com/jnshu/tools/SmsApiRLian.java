package com.jnshu.tools;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * @program: smsdemo
 * @description: SMS sdk 工具
 * @author: Mr.xweiba
 * @create: 2018-05-29 01:26
 **/

public class SmsApiRLian {
    private static Logger logger = LoggerFactory.getLogger(SmsApiRLian.class);
    private String accountSid;
    private String accountToken;
    private String Rand_Code;
    private String appId;

    @Autowired
    MemCachedClient memCachedClient;

    SmsApiRLian(String accountSid, String accountToken, String AppId){
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.appId = AppId;
    }

    public boolean sendSMS(String telephone_Number, String SessionId){
        return sendSMStReal(telephone_Number, SessionId);
    }

    private boolean sendSMStReal(String telephone_Number, String SessionId) {
        Rand_Code = RandNum.getRandLength(4);
        logger.debug("Rand_Code: " + Rand_Code);
        HashMap<String, Object> result = null;
        // 初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        /* 初始化服务器地址和端口   */
        // 沙盒模式 | 内测模式
        restAPI.init("sandboxapp.cloopen.com", "8883");
        // 生产环境
        // restAPI.init("app.cloopen.com", "8883");

        /* 初始化主账号和主令牌 ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取 */
        try {
            restAPI.setAccount(accountSid, accountToken);
        } catch (Exception e){
            return false;
        }

        /* 初始化应用ID 应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID */
        restAPI.setAppId(appId);

        /* 发送短信 */
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
        //*第三个参数是要替换的内容数组。
        /* 给17050071261按照官网模板 1 发送验证码 6543 1分钟后失效 */
        result = restAPI.sendTemplateSMS(telephone_Number, "1", new String[]{Rand_Code,"1"});
        memCachedClient.set(Rand_Code + SessionId, telephone_Number, new Date(1000*60));
        logger.debug("缓存值: " + memCachedClient.get(Rand_Code + SessionId) + " key: " + Rand_Code + SessionId);

        // System.out.println(Rand_Code);
        /* 输出发送返回信息 */
        logger.debug("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                logger.debug(key +" = "+object);
            }
            return true;
        }else{
            //异常返回输出错误码和错误信息
            logger.debug("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return false;
        }
    }
}