package yxpTask6.util;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.ServicePojo.SMSAccount;

import java.util.HashMap;
import java.util.Set;
@Component
public class SMSUtil
{
    @Autowired
    SMSAccount smsAccount;
    public String getSMS(String mobile)
    {
        String str=null;
        HashMap<String, Object> result = null;
        String code=(int)((Math.random()*9+1)*1000)+"";
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        restAPI.init("sandboxapp.cloopen.com", "8883");
        restAPI.setAccount(smsAccount.getAccountSid(), smsAccount.getAccountToken());
        restAPI.setAppId(smsAccount.getAppId());
        result = restAPI.sendTemplateSMS(mobile,"1" ,new String[]{code,"5"});
//        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
            str=code;
            return str;
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
        return str;
    }
}
