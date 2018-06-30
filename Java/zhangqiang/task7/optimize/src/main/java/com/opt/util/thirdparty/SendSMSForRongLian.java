package com.opt.util.thirdparty;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

public class SendSMSForRongLian {

    private static final String ACCOUNT_SID = "";
    private static final String AUTH_TOKEN = "";
    private static final String APPID = "";


    public static HashMap sendTemplateSMS(String to, String templateId, String[] datas){

        HashMap<String, Object> result = null;

        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        restAPI.init("app.cloopen.com", "8883");
        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
        restAPI.setAccount(ACCOUNT_SID, AUTH_TOKEN);
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAppId(APPID);
        // 请使用管理控制台中已创建应用的APPID。
//        result = restAPI.sendTemplateSMS("号码1,号码2等","模板Id" ,new String[]{"模板内容1","模板内容2"});
        result = restAPI.sendTemplateSMS(to,templateId ,datas);

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
            return  result;
        }

        return result;

    }

    @Test
    public void test(){
        //"验证码"，"分钟数"
        String[] datas = new String[]{"7788","3"};
        sendTemplateSMS("18638292925","1",datas);
    }

}
