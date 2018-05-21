package com.util;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TextContent;
import com.sendcloud.sdk.util.ResponseData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendEmail  {
    private String from;
    private String fromName;
    private String replyTo;
    private String subject;
    private String localhost;

    static Logger logger = (Logger) LoggerFactory.getLogger(SendEmail.class);

    public void setFrom(String from) {
        this.from = from;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    //普通邮件

    public  void send_common(String email, String userName, String addressCode) throws Throwable {
        //接收器
        MailAddressReceiver receiver = new MailAddressReceiver();
        // 添加收件人
        receiver.addTo(email);
        // 添加抄送
        //receiver.addCc("304584817@qq.com");
        // 添加密送
        //receiver.addBcc("304584817@qq.com");
        //邮件体
        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(from);
        // 设置 FromName
        body.setFromName(fromName);
        // 设置 ReplyTo
        body.setReplyTo(replyTo);
        // 设置标题
        body.setSubject(subject);
        // 创建文件附件
        //body.addAttachments(new File("D:/1.png"));
        //body.addAttachments(new File("D:/2.png"));
        //// 创建流附件
        //body.addAttachments(new FileInputStream(new File("D:/ff.png")));

        //邮件内容
        TextContent content = new TextContent();
        content.setContent_type(TextContent.ScContentType.html);

        String url =  localhost + "login?userName="+ userName +"&email_code="+ addressCode;
        //String url = "https://www.baidu.com";
        content.setText("<html><p>感谢注册，点击下面链接完成账号激活，如果不能跳转，复制链接到浏览器地址栏</p><a href='"+ url +"'>"+ url +"</a></html>");

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);

        SendCloud sc = SendCloudBuilder.build();
        ResponseData res = sc.sendMail(mail);
        logger.info("邮件发送状态"+ res.getMessage());
//        System.out.println(res.getResult());
//        System.out.println(res.getStatusCode());
//        System.out.println(res.getMessage());
//        System.out.println(res.getInfo());
    }


}
