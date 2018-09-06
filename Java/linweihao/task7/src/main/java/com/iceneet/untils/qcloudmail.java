package com.iceneet.untils;

import com.sun.mail.util.MailSSLSocketFactory;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Component
public class qcloudmail {
    @Value("${Qcloud.Email.account}")
    private String account;

    @Value("${Qcloud.Email.pass}")
    private String pass;

    @Value("${Qcloud.Email.host}")
    private String host;

    @Value("${Qcloud.Email.port}")
    private String port;

    @Value("${Qcloud.Email.protocol}")
    private String protocol;

    @Autowired
    private  FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private RedisTemplate redisTemplate;

    public String send(String email) throws MessagingException {

        Properties prop = new Properties();
        //协议
        prop.setProperty("mail.transport.protocol", protocol);
        //服务器
        prop.setProperty("mail.smtp.host", host);
        //端口
        prop.setProperty("mail.smtp.port", port);
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //
        //获取Session对象
        Session s = Session.getDefaultInstance(prop, new Authenticator() {
            //此访求返回用户和密码的对象
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication pa = new PasswordAuthentication(account, pass);
                return pa;
            }
        });
        //设置session的调试模式，发布时取消
        s.setDebug(false);
        MimeMessage mimeMessage = new MimeMessage(s);
        int times =0;
        if(redisTemplate.opsForValue().get("email"+email)!=null){
            times = (int) redisTemplate.opsForValue().get("email"+email);
            System.out.println("Times:"+times);
        }
        if (times<3) {
            try {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
                String code = RandomCode.getFourRandom();
                String html = getMailText(code);
                //设置主题
                helper.setSubject("注册验证码");
                helper.setSentDate(new Date());
                //设置发送人
                helper.setFrom(new InternetAddress(account));
                //设置收件人
                helper.setTo(new InternetAddress(email));
                //设置内容
                helper.setText(html, true);
                mimeMessage.saveChanges();
                //发送
                Transport.send(mimeMessage);
                if (times==0){
                    redisTemplate.opsForValue().set("email"+email,0,12,TimeUnit.HOURS);
                }
                redisTemplate.opsForValue().set(email, code, 10, TimeUnit.MINUTES);
                redisTemplate.opsForValue().increment("email"+email,1);
                return "success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "fail";
            } catch (TemplateException e) {
                e.printStackTrace();
                return "fail";
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            }
        }else {
            return "超过验证次数";
        }
    }
    //获得模板
    public String getMailText(String code) throws IOException, TemplateException {
        System.out.println(freeMarkerConfigurer);
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("emailtemplate.ftl");
        Map<String,String> map = new HashMap<String,String>();
        map.put("code",code);
        String htmlTxt = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
        return htmlTxt;
    }


}
