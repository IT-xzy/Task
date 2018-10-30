package com.rmi;
/*
 * @ClassName:RMIServer
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/13 11:45
 **/

import com.service.CompanyService;
import com.service.ProfService;
import com.service.TelCodeService;
import com.service.UserService;
import com.service.thirdParty.EmailService;
import com.service.thirdParty.QiNiuService;
import com.service.thirdParty.TelService;

public interface RMIServer {

    UserService getUserService();

    public ProfService getProfService();

    public CompanyService getCompanyService();

    public TelCodeService getTelCodeService();

    public EmailService getEmailService();

    public QiNiuService getQiNiuService();

    public TelService getTelService();

    void getName();
}
