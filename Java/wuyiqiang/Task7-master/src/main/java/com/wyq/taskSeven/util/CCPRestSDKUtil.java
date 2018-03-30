package com.wyq.taskSeven.util;

import com.cloopen.rest.sdk.CCPRestSDK;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class CCPRestSDKUtil {

    private static Logger logger = Logger.getLogger(CCPRestSDKUtil.class);

    private HashMap<String, Object> result = null;
    private static CCPRestSDK restAPI = new CCPRestSDK();

    public CCPRestSDKUtil(){}

    public CCPRestSDKUtil(String serverIP, String serverPort, String accountSid, String accountToken, String appId) {
        restAPI.init(serverIP, serverPort);// 初始化服务器地址和端口
        restAPI.setAccount(accountSid, accountToken);// 初始化主帐号和主帐号TOKEN
        restAPI.setAppId(appId);// 初始化应用ID
    }

    public boolean sendVerificationCode(String to, String templateId, String[] datas) {
        result = restAPI.sendTemplateSMS(to, templateId, datas);
        boolean flag = false;
        if ("000000".equals(result.get("statusCode"))) {
            flag = true;
            //正常返回输出data包体信息（map）
            String log = null;
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                log += (key + " = " + object);
            }
            logger.info(log);
        } else {
            //异常返回输出错误码和错误信息
            flag = false;
            logger.error("phoneNum=" + to + "错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        return flag;
    }

}
