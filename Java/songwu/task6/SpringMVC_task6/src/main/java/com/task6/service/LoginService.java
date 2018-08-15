package com.task6.service;

import com.task6.pojo.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by SongWu on 2018/7/2
 */
public interface LoginService {
    //    注册
    public String loginForm(Person person);


    //   登录
    public String login(Person person);


    //    注销
    public String off(HttpServletRequest request, HttpServletResponse response);

    //    重置
    public String reset(Person person, String password2,String repassword2);
}
