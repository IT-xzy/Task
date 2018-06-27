package service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Email;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class EmailServiceTest {
    @Resource
    Email email;
    @Autowired
    EmailService emailService;
    @Test
    public void test1() throws MessagingException {
        emailService.sendMail("275937729@qq.com");
    }

    @Test
    public void test2(){
        System.out.println(email.getUser());
        System.out.println(email.getPassword());
        System.out.println(email.getProtocol());
        System.out.println(email.getHost());
    }


}