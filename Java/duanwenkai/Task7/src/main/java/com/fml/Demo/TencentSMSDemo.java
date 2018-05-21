package com.fml.Demo;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class TencentSMSDemo {
    // 短信应用SDK AppID
    int appid = 1400081087; // 1400开头

    // 短信应用SDK AppKey
    String appkey = "1c3794ed0ce290f07922b3208e364d30";

    // 需要发送短信的手机号码
    //String[] phoneNumbers = null;
    String phoneNumber;

    @RequestMapping("aaa")
    public void sendSMS(){
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber,
                    "您的验证码是: 5678", "", "");
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }

}
