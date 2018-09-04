//package com.iceneet.untils;
//
//import com.sun.mail.util.MailSSLSocketFactory;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.security.GeneralSecurityException;
//import java.util.Date;
//import java.util.Properties;
//
//public class Sending {
//    public static void main(String[] args) throws Exception {
//        Properties prop = new Properties();
//        //协议
//        prop.setProperty("mail.transport.protocol", "smtp");
//        //服务器
//        prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
//        //端口
//        prop.setProperty("mail.smtp.port", "465");
//        //使用smtp身份验证
//        prop.setProperty("mail.smtp.auth", "true");
//        //使用SSL，企业邮箱必需！
//        //开启安全协议
//        MailSSLSocketFactory sf = null;
//        try {
//            sf = new MailSSLSocketFactory();
//            sf.setTrustAllHosts(true);
//        } catch (GeneralSecurityException e1) {
//            e1.printStackTrace();
//        }
//        prop.put("mail.smtp.ssl.enable", "true");
//        prop.put("mail.smtp.ssl.socketFactory", sf);
//        //
//        //获取Session对象
//        Session s = Session.getDefaultInstance(prop,new Authenticator() {
//            //此访求返回用户和密码的对象
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                PasswordAuthentication pa = new PasswordAuthentication("admin@iceneet.club", "Weihao2008");
//                return pa;
//            }
//        });
//        //设置session的调试模式，发布时取消
//        s.setDebug(true);
//        MimeMessage mimeMessage = new MimeMessage(s);
//        try {
//            mimeMessage.setFrom(new InternetAddress("admin@iceneet.club"));
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("651369070@qq.com"));
//            //设置主题
//            mimeMessage.setSubject("主题");
//            mimeMessage.setSentDate(new Date());
//            //设置内容
//            mimeMessage.setText("正文内容");
//            mimeMessage.saveChanges();
//            //发送
//            Transport.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
//
