package cn.summerwaves.util;


import config.AppConfig;
import lib.MAILSend;
import org.apache.log4j.Logger;
import utils.ConfigLoader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {
    private static Logger log = Logger.getLogger(EmailUtil.class);
    private static String appId;
    private static String appKey;

    //账户信息配置
    private static MAILSend createConfig() {
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
        config.setAppId(appId);
        config.setAppKey(appKey);
        return new MAILSend(config);
    }

    //API发送主体
    public static void sendEmail(String receiver, String code) {
        //接收人、发送人、短信内容配置
        MAILSend submail = createConfig();
        submail.addTo(receiver,"receiver");
        submail.setSender("summerwaves@summerwaves.cn","sender");
        submail.setSubject("验证码");
        submail.setText("验证码" + code);

        //抓取第三方API在控制台输出的内容
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        submail.send();
        String message = baoStream.toString();
        System.setOut(oldStream);
        System.out.println(message);

        //正则表达式判断部分
        Pattern pattern = Pattern.compile("success|error");//判断成功或失败
        Pattern patternStatusCode = Pattern.compile(":\\d{3}");//获取错误码
        Pattern patternReason = Pattern.compile("(?<=\"msg\":\").*(?=\"})");//获取失败原因

        //正则表达式匹配部分
        Matcher matcher = pattern.matcher(message);
        Matcher matcherReason = patternReason.matcher(message);
        Matcher matcherStatusCode = patternStatusCode.matcher(message);

        //依据正则表达式返回信息打印日志
        if (matcher.find()) {
            if (matcher.group(0).equals("success")) {
                //成功
                log.info("Email be sent successfully");

            } else {
                matcherStatusCode.find();
                matcherReason.find();
                //失败，返回状态码及其失败原因
                log.error("Email be sent unsuccessful,The statusCode " + matcherStatusCode.group(0)
                        + ", the reason is "+matcherReason.group(0) );//

            }
        } else {
            //发生未知错误，正则表达式抓取失败
            log.error("An unknown error occurred while sending the email ");
        }
    }

    public void setAppId(String appId) {
        EmailUtil.appId = appId;
    }

    public void setAppKey(String appKey) {
        EmailUtil.appKey = appKey;
    }

}
