package cn.summerwaves.util;

import com.cloopen.rest.sdk.CCPRestSDK;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class SMSUtil {
    private static String account;
    private static String token;
    private static String appId;
    protected static Logger log = Logger.getLogger(SMSUtil.class);

    //加载账户配置
    private static CCPRestSDK create() {
        CCPRestSDK restAPI = new CCPRestSDK();
        // 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
        restAPI.init("app.cloopen.com", "8883");
        restAPI.setAccount(account, token);// 初始化主帐号和主帐号TOKEN
        restAPI.setAppId(appId);// 初始化应用ID
        return restAPI;
    }

    public static void sendSMS(String tel,String code, String min) {
        CCPRestSDK restAPI = create();
        HashMap<String, Object> result = null;

        //发送短信，参数为：号码--模板--验证码--验证码有效时间
        result = restAPI.sendTemplateSMS(tel, "1", new String[]{code, min});

        //判断发送是否成功，不成功返回状态码
        if (result.get("statusCode").equals("000000")) {
            log.info("SMS be sent successfully");
        } else {
            log.error("SMS be sent unsuccessful,The statusCode is " + result.get("statusCode"));
        }

/*        System.out.println("SDKTestSendTemplateSMS result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
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
    }

    public void setAccount(String account) {
        SMSUtil.account = account;
    }


    public void setToken(String token) {
        SMSUtil.token = token;
    }


    public void setAppId(String appId) {
        SMSUtil.appId = appId;
    }

}
