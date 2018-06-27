package com.task.util;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TextContent;
import com.sendcloud.sdk.util.ResponseData;
import com.sendcloud.sdk.model.TextContent.ScContentType;

public class EmailUtil {

    public static boolean sendTo(String email,String code) throws Throwable {

        MailAddressReceiver receiver = new MailAddressReceiver();

        receiver.addTo(email);// 添加收件人

        MailBody body = new MailBody();

        body.setFrom("sendcloud@sendcloud.org");// 设置 From

        body.setFromName("Jnshu");// 设置 FromName

        body.setReplyTo("reply@sendcloud.org");// 设置 ReplyTo

        body.setSubject("注冊验证码，勿回复");// 设置标题


        TextContent content = new TextContent();
        content.setContent_type(ScContentType.html);
        content.setText("<html><p>"+code+"</p></html>");

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);

        SendCloud sc = SendCloudBuilder.build();
        ResponseData res = sc.sendMail(mail);
        System.out.println(res.getResult());
        System.out.println(res.getStatusCode());
        System.out.println(res.getMessage());
        System.out.println(res.getInfo());

        return res.getResult();
    }
}
