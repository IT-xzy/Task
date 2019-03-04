package com.jnshu.task7.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SendMsgUtil {

    private static final String ACCOUNTSID  = "8a253";
    private static final String TOKEN = "5a8a7736";
    private static final String APPID = "8a5a";

    /**
     * 发送短信消息
     * 方法说明
     * @Discription:扩展说明
     * @param phones
     * @param content
     * @return
     * @return String
     */
    @SuppressWarnings("deprecation")
    public static String sendMsg(String phones,String content) {
        try {
            content = java.net.URLEncoder.encode(content,"utf-8");
            System.out.println(content);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //短信接口URL提交地址
        String nowTime = TimeUtil.newTime();
        String SigParameter = Md5Util.digest(ACCOUNTSID + TOKEN + nowTime);
        System.out.println(SigParameter);
        String url = "https://app.cloopen.com:8883/2013-12-26/Accounts/" + ACCOUNTSID + "/SMS/TemplateSMS?sig=" + SigParameter;

        Map<String, String> params = new HashMap<String, String>();

        params.put("to", phones);
        params.put("appId", APPID);
        params.put("templateId", "1");
        params.put("datas",createRandomVcode());

//        //手机号码，多个号码使用英文逗号进行分割
//        params.put("hm", phones);
//        //将短信内容进行URLEncoder编码
//        params.put("nr", URLEncoder.encode(content));

        return HttpRequestUtil.getRequest(url, params);
    }

    /**
     * 随机生成6位随机验证码
     * 方法说明
     * @Discription:扩展说明
     * @return
     * @return String
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
    /**
     * 测试
     * 方法说明
     * @Discription:扩展说明
     * @param args
     * @return void
     */
    public static void main(String[] args) {
      System.out.println(SendMsgUtil.createRandomVcode());
//      System.out.println("&ecb=12".substring(1));
        System.out.println(sendMsg("17600976719", "【签名】尊敬的用户，您的验证码为" + SendMsgUtil.createRandomVcode() + "，请在10分钟内输入。请勿告诉其他人!"));
    }
}
