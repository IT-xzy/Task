package com.jnshu.utils;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private static Logger logger = Logger.getLogger(MailUtil.class);
    //配置服务器
    private static final String ALIDM_SMTP_HOST = "smtpdm.aliyun.com";
    private static final String AUTH = "true";
    private static final String CLASS = "javax.net.ssl.SSLSocketFactory";
    private static final String SOCKETFACTORY_PORT = "465";//为什么不用25端口，因为现在的阿里云已经将25禁用了
    private static final String PORT = "465";
    private static final String FROM = "fz@sloves.crjmlhyz.top";//这个是你设置发信地址的时候的发信地址
    private static final String PASSWORD = "SKbofangqi52";//这个就是你设置的STMP的密码

    public static int SendMail(String email, String code) {
        logger.info("发送邮件！！");
        int x = 0;
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.socketFactory.class", CLASS);
        props.put("mail.smtp.socketFactory.port", SOCKETFACTORY_PORT);
        props.put("mail.smtp.port", PORT);
        // 发件人的账号
        props.put("mail.user", FROM);
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", PASSWORD);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        //        mailSession.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {
            // 设置发件人
            InternetAddress from = new InternetAddress(FROM);
            message.setFrom(from);
            Address[] a = new Address[1];
            a[0] = new InternetAddress(FROM);
            message.setReplyTo(a);
            // 设置收件人
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            // 设置邮件标题
            message.setSubject("验证邮件");
            StringBuilder s = new StringBuilder();
            s.append(code);
            logger.error(s);
            message.setContent(s.toString(), "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println(e);
            logger.info("发送邮件失败，错误是：" + e);
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
            System.out.println(err);
        }
        return x;
    }
}