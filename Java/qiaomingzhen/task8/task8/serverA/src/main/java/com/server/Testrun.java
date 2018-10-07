package com.server;
/*
 * @ClassName:Testrun
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/10 1:07
 **/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testrun {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.getBean("userService");
        context.getBean("companyService");
        context.getBean("profService");
        context.getBean("telCodeService");
        context.getBean("companyService");
        context.getBean("emailService");
        context.getBean("qiNiuService");
        context.getBean("telService");
    }
}
//    TelCodeService telCodeService;
//    ProfService profService;
//    CompanyService companyService;
//    EmailService emailService;
//    QiNiuService qiNiuService;
//    TelService telService;