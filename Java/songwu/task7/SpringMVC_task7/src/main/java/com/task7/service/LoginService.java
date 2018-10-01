package com.task7.service;

import com.task7.pojo.Person;

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

    //根据用户名查询
    Person selectLogin(String username);

    //更新手机号
    boolean updatePhone(Person person);

    //   动态更新支持图片，手机号，邮箱
    boolean updatePerson(Person person);

}
