package com.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.ArrayList;

/**
 * @author Arike
 * Create_at 2018/1/23 15:08
 */
public class Sms {
    
    public static void send(String code,String phone){
        //假设短信模板 id 为 123，模板内容为：测试短信，{1}，{2}，{3}，上学。
        SmsSingleSender sender = null;
        try {
            sender = new SmsSingleSender(1400063353,"072a113a90c24573874e2415ec8bbb40");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> params = new ArrayList<String>();
        params.add(code);
        params.add("3");
        SmsSingleSenderResult result = null;
        try {
            result = sender.sendWithParam("86", phone, 78870, params, "", "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
    
}
