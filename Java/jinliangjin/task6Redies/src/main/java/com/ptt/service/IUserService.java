package com.ptt.service;

import com.ptt.pojo.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: IUserService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:34
 * @Version: 1.0
 */
public interface IUserService {
    String register(User user);
    User selectByName(String name);//通过用户名查询
    boolean login(HttpServletResponse response, User user, String rememberMe, HttpSession session);//登录
    void logout(HttpServletRequest request, HttpServletResponse response);//退出登录状态
}
