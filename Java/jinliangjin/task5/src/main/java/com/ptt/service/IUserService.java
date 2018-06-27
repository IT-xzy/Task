package com.ptt.service;

import com.ptt.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: IUserService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:34
 * @Version: 1.0
 */
public interface IUserService {
    Boolean register(User user);
    User selectByName(String name);//通过用户名查询
    User login(HttpServletResponse response, User user, String rememberMe);//登录
    void logout(HttpServletRequest request, HttpServletResponse response);//退出登录状态
}
