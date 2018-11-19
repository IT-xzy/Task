package task7.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import javax.swing.*;

public class TestSendMail {
    public void sample(){
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），
        // 需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile= DefaultProfile.getProfile
                ("cn-hangzhou", "LTAIYJkbrR5aHKIX", "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new  DefaultAcsClient(profile);
        SingleSendMailRequest request =new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            //控制台创建的发信地址
            request.setAccountName("thq2828@haiqing.shop");
            //发信人昵称
            request.setFromAlias("海清");
            //取值范围 0~1: 0 为随机账号；1 为发信地址。
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName("haiqing2828");
            //使用管理控制台中配置的回信地址（状态必须是验证通过）
            request.setReplyToAddress(true);
            //目标地址
            request.setToAddress("1015320765@qq.com");
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");

            //邮件主题
            request.setSubject("task7测试!");
            //邮件正文
            request.setHtmlBody("你的验证码是282896");
            SingleSendMailResponse httpResponse=client.getAcsResponse(request);
        } catch (ClientException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestSendMail mail =new TestSendMail();
        mail.sample();
    }
}
