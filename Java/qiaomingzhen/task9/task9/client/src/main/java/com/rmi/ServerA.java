package com.rmi;
/*
 * @ClassName:Server1
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/12 22:23
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
public class ServerA implements RMIServer {
    @Autowired
    @Qualifier("userServiceA")
    UserService userService;

    @Autowired
    @Qualifier("profServiceA")
    ProfService profService;

    @Autowired
    @Qualifier("companyServiceA")
    CompanyService companyService;

    @Autowired
    @Qualifier("telCodeServiceA")
    TelCodeService telCodeService;

    @Autowired
    @Qualifier("emailServiceA")
    EmailService emailService;

    @Autowired
    @Qualifier("qiNiuServiceA")
    QiNiuService qiNiuService;

    @Autowired
    @Qualifier("telServiceA")
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
        System.out.println("server1");
    }
}
