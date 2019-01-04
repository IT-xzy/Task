package task7.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;

public class SendMailUtil {
    private static Logger logger = Logger.getLogger(DysSmsUtil.class);
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static String accessKeyId = "LTAIYJkbrR5aHKIX";
    private static String accessKeySecret = "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut";
    private static String regionId = "cn-hangzhou";
    //控制台创建的发信地址
    private static String accountName = "thq2828@haiqing.shop";
    //控制台创建的标签
    private static String tagName = "haiqing2828";
    //发信人昵称
    private static String fromAlias = "海清";
    //邮件主题
    private static String subject = "task7测试!";

    //产生分随机数封装在工具类的属性里面，用于缓存的装入
    public static String number = randomNumber();

    //封装一个产生随机6位数的字符串
    private static String randomNumber() {
        int i = (int) ((Math.random() * 9 + 1) * 100000);
        return Integer.toString(i);
    }

    //初始化acsClient
    private static IAcsClient acsClient;

    static {
        if (acsClient == null) {
            logger.info("初始化acsClient");
            // 如果是除杭州region外的其它region（如新加坡、澳洲Region），
            // 需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
            // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
            //try {
            //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
            //} catch (ClientException e) {
            //e.printStackTrace();
            //}
            acsClient = new DefaultAcsClient(profile);
        }
    }

    //初始化邮件发送接口
    private static SingleSendMailRequest request;

    static {
        if (request == null) {
            request = new SingleSendMailRequest();
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            //控制台创建的发信地址
            request.setAccountName(accountName);
            //发信人昵称
            request.setFromAlias(fromAlias);
            //取值范围 0~1: 0 为随机账号；1 为发信地址。
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName(tagName);
            //使用管理控制台中配置的回信地址（状态必须是验证通过）
            request.setReplyToAddress(true);
            request.setSubject(subject);


        }
    }
    public static SingleSendMailResponse sendMail(String address){
        logger.info("进入sendMail();");
        //目标地址
        request.setToAddress(address);
        //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
        //request.setToAddress("邮箱1,邮箱2");
        //邮件正文
        request.setHtmlBody("你的验证码是"+number);
        SingleSendMailResponse httpResponse=null;
        try {
             httpResponse=acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static void main(String[] args) {
        SingleSendMailResponse httpResponse=sendMail("1015320765@qq.com");
        System.out.println(httpResponse.getRequestId()+","+httpResponse.getEnvId());
    }
}
