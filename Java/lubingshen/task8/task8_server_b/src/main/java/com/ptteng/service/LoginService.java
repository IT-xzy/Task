package com.ptteng.service;

import com.ptteng.pojo.model.Email;
import com.ptteng.pojo.model.Login;
import com.ptteng.pojo.model.User;

import java.util.Map;

public interface LoginService {
    //登录验证，并且返回用户和token值
    Map<String,String> checkLogin(Login login) throws Exception;

    //发送手机注册验证短信
    String sendPhoneCode(User user, String ip) throws Exception;

    //验证成功，手机注册
    Long registerByPhone(User user) throws Exception;

    //邮件注册预检查
    void checkSigningMail(User user) throws Exception;

    //发送激活邮件
    String sendActivateMail(Email email, String basePath) throws Exception;

    //验证成功，邮件注册
    User registerByMail(String token,String ip) throws Exception;
}
