package com.iceneet.untils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class qcloudsms {
//    private static int AppID = 1400127686;
//    private static String AppKey = "50e65ab0e1ca4b202614a05e59ba9ca3";
    private static String phone = "18819457395";
//    private static int templateId = 178034;
//    private static String smsSign = "快乐咸鱼的每一天";

    @Value("${Qcloud.sms.AppId}")
    private int AppID;

    @Value("${Qcloud.sms.AppKey}")
    private String AppKey;

    @Value("${Qcloud.sms.templateId}")
    private int templateId;

    @Value("${Qcloud.sms.smsSign}")
    private String smsSign;

    @Autowired
    private RedisTemplate  redisTemplate;

    //验证码短信发送
    public  String SendMsg(String phone) throws HTTPException, IOException {
        int times =0;
        if(redisTemplate.opsForValue().get("phone"+phone)!=null){
            times = (int) redisTemplate.opsForValue().get("phone"+phone);
            System.out.println("Times:"+times);
        }
        if (times<3) {
            try {
                String code = RandomCode.getFourRandom();
                String time = "10";
                String[] params = {code, time};
                SmsSingleSender ssender = new SmsSingleSender(AppID, AppKey);
                SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                        templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                if (times==0){
                    redisTemplate.opsForValue().set("phone"+phone,0,12,TimeUnit.HOURS);
                }
                redisTemplate.opsForValue().set(phone, code, 3, TimeUnit.MINUTES);
                redisTemplate.opsForValue().increment("phone"+phone,1);
                return code;
            } catch (HTTPException e) {
                // HTTP响应码错误
                e.printStackTrace();
                return "http error";
            } catch (JSONException e) {
                // json解析错误
                e.printStackTrace();
                return "json error";
            } catch (IOException e) {
                // 网络IO错误
                e.printStackTrace();
                return "io error";
            }
        }else {
            return "手机超过验证次数";
        }
    }
}
