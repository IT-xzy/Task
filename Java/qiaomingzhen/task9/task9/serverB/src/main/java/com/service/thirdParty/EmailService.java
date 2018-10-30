package com.service.thirdParty;
/*
 * @ClassName:EmailService
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/13 12:54
 **/

import com.service.BaseService;

import javax.servlet.http.HttpServletRequest;

public interface EmailService extends BaseService {

    public boolean sendCommon(String html, String rcpt_to);
    public String getHtml(String url, String email, String name, String randCode);
    public boolean checkEmail(String randCode, String name);
    public boolean sentEmail(HttpServletRequest request, String randCode, String emailType);

}
