package lujing.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.SmsVoiceVerifyCodeSender;
import com.github.qcloudsms.SmsVoiceVerifyCodeSenderResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lujing
 * @return 发送结果result。0，成功，其他，失败
 * Create_at 2018/1/19 18:52
 */
public class SMSUtil {
    public static Integer sendSMS(String code, String phoneNum) {
        
        try {
            SmsSingleSender sender = new SmsSingleSender(1400063353, "072a113a90c24573874e2415ec8bbb40");
            ArrayList<String> params = new ArrayList<>();
            params.add(code);
            params.add("15");
            
            SmsSingleSenderResult result = sender.sendWithParam("86", phoneNum, 78870, params, "", "", "");
            System.out.println(result);
            
            return result.result;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1007;
    }
    
    public static void sendVoiceSms() {
        SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(1400063353, "072a113a90c24573874e2415ec8bbb40");
        SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = null;
        
        try {
            smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86", "18200239820", "898989", 2, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(smsVoiceVerifyCodeSenderResult);
    }
    
    public static void main(String[] args) {

        System.out.println(fun());
    }
    
    public static int fun() {
        int x = 1;
        try {
            
            return x++;
            
        } catch (Exception e) {
            return x++;
        } finally {
            
            return x++;
        }
 
        
    }
    
}
