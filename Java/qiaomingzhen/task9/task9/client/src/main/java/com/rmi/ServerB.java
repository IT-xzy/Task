package com.rmi;
/*
 * @ClassName:Server2
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/12 22:24
 **/

import com.service.CompanyService;
import com.service.ProfService;
import com.service.TelCodeService;
import com.service.UserService;
import com.service.thirdParty.EmailService;
import com.service.thirdParty.QiNiuService;
import com.service.thirdParty.TelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerB implements RMIServer{
    @Autowired
    @Qualifier("userServiceB")
    UserService userService;

    @Autowired
    @Qualifier("profServiceB")
    ProfService profService;

    @Autowired
    @Qualifier("companyServiceB")
    CompanyService companyService;

    @Autowired
    @Qualifier("telCodeServiceB")
    TelCodeService telCodeService;

    @Autowired
    @Qualifier("emailServiceB")
    EmailService emailService;

    @Autowired
    @Qualifier("qiNiuServiceB")
    QiNiuService qiNiuService;

    @Autowired
    @Qualifier("telServiceB")
    TelService telService;


    @Override
    public UserService getUserService() {
        return userService;
    }

    public ProfService getProfService() {
        return profService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public TelCodeService getTelCodeService() {
        return telCodeService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public QiNiuService getQiNiuService() {
        return qiNiuService;
    }

    public TelService getTelService() {
        return telService;
    }

    public void getName(){
        System.out.println("server2");
    }
}
