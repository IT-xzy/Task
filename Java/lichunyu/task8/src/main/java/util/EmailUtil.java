package util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.Email;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件推送服务实现类
 */
@Service
public class EmailUtil {
    @Resource
    private Email email;
    Logger log = Logger.getLogger(EmailUtil.class);

    public void sendMail(String to,String code) throws MessagingException {
        Properties prop=new Properties();
        prop.put("mail.host",email.getHost());
        prop.put("mail.port",email.getPort());
        prop.put("mail.transport.protocol", email.getProtocol());
        prop.put("mail.smtp.auth", email.getAuth());
        //使用java发送邮件5步骤
        //1.创建session
        Session session=Session.getInstance(prop);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts=session.getTransport();
        //3.通过邮件用户名密码链接，阿里云默认是开启个人邮箱pop3、smtp协议的，所以无需在阿里云邮箱里设置
        ts.connect(email.getUser(), email.getPassword());

        //4.创建邮件
        Message msg=createSimpleMail(session,to,code);
        //5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());
    }

    private MimeMessage createSimpleMail(Session session, String to,String code) throws AddressException,MessagingException{
        //创建邮件对象
        MimeMessage mm=new MimeMessage(session);
        //设置发件人
        mm.setFrom(new InternetAddress(email.getUser()));
        //设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //设置抄送人
        mm.setRecipient(Message.RecipientType.CC, new InternetAddress(email.getCc()));
        String content = "注册验证码："+code+"\n"+"五分钟内有效，请勿泄露给他人";
        mm.setSubject("欢迎注册 lichunyu.top");
        mm.setContent(content, "text/html;charset=gbk");
        return mm;
    }

}

