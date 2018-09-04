package com.jnshu.tools;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SmsUtil {

    // 短信应用SDK AppID
   static int appid; // 1400开头

    // 短信应用SDK AppKey
   static String appkey;


    // 短信模板ID，需要在短信应用中申请
  static   int templateId ; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

    // 签名
  static   String smsSign;
  // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`


    public void setAppid(int appid) {
        SmsUtil.appid = appid;
    }

    public void setAppkey(String appkey) {
        SmsUtil.appkey = appkey;
    }

    public void setTemplateId(int templateId) {
        SmsUtil.templateId = templateId;
    }

    public void setSmsSign(String smsSign) {
        SmsUtil.smsSign = smsSign;
    }

    public static String SMS(String phoneNumber, String code, String validity ) {


        String rs = "false";
        try

        {
            String[] params = {code,validity};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
            rs = result.toString();
        } catch (
                HTTPException e)

        {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (
                JSONException e)

        {
            // json解析错误
            e.printStackTrace();
        } catch (
                IOException e)

        {
            // 网络IO错误
            e.printStackTrace();
        }
        return rs;
    }
}