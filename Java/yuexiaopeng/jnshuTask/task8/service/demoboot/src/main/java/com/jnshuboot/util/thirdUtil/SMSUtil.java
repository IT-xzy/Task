package com.jnshuboot.util.thirdUtil;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.jnshuboot.pojo.ServicePojo.SMSAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Slf4j
@Component
public class SMSUtil {
    @Autowired
    SMSAccount smsAccount;

    /**
     * 获得手机验证码方法
     *
     * @param mobile 待发送手机号，发送之前已进行完格式验证
     * @return 验证码或null；
     */
    public String getSMS(String mobile) {
        String str = null;
        HashMap<String, Object> result = null;
        //生成4位随机数
        String code = (int) ((Math.random() * 9 + 1) * 1000) + "";
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        restAPI.init("sandboxapp.cloopen.com", "8883");
        restAPI.setAccount(smsAccount.getAccountSid(), smsAccount.getAccountToken());
        restAPI.setAppId(smsAccount.getAppId());
        result = restAPI.sendTemplateSMS(mobile, "1", new String[]{code, "5"});
//        System.out.println("SDKTestGetSubAccounts result=" + result);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                log.info(key + " = " + object);
            }
            str = code;
            return str;
        } else {
            //异常返回输出错误码和错误信息
            log.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        return str;
    }
}
