package com.jnshu.sdk;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.jnshu.tools.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Set;

/**
 * @program: Tiles
 * @description:
 * @author: Mr.Lee
 * @create: 2018-07-23 09:36
 **/
public class SmsClient {
    private static Logger logger = LoggerFactory.getLogger(SmsClient.class);
    private String accountSid;
    private String accountToken;
    private String Rand_Code;
    private String appId;

    public SmsClient(String accountSid, String accountToken, String AppId) {
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.appId = AppId;
    }

    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }


    public Msg sendSMS(String phone) {

        logger.debug("random code:" + createRandomVcode());

        HashMap<String ,Object> result = null;
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
        restAPI.init("app.cloopen.com","8883");

        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount(accountSid,accountToken);

        // 使用管理控制台中已创建应用的APPID。
        restAPI.setAppId(appId);

        result = restAPI.sendTemplateSMS(phone,"1",
                new String[]{createRandomVcode(),"2"});
        System.out.println("SDKTestGetSubAccounts result="+result);

        if ("000000".equals(result.get("statusCode"))){
            HashMap<String ,Object> data = (HashMap<String ,Object>) result.get("data");
            Set<String > keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + "= " + object);
            }
            return Msg.success();
        }
        else {
            // 异常返回 输出错误码和错误信息
            System.out.println("错误码 = " + result.get("statusCode") + "错误信息" + result.get("statusMsg"));
            return Msg.fail();
        }
    }
}
