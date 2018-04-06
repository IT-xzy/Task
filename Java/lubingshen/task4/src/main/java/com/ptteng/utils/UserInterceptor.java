package com.ptteng.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptteng.exception.XSSException;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (!check(request)) {
            request.getRequestDispatcher("/login").forward(request, response);
        }
        return true;
    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }


    private boolean check(HttpServletRequest request) throws Exception {
        Boolean result = false;
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0)
            return false;
        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals("Token"))
                continue;
            if (!cookie.getValue().equals(request.getSession().getAttribute("user")))
                continue;
            //防止第三方脚本偷取Cookie进行XSS攻击，需要进行时间戳验证
            //这样子就很好理解，为什么token里面要放用户名和登录时间戳了
            DesUtil desUtil = new DesUtil("java");
            String[] token = desUtil.decrypt(cookie.getValue()).split(",");
            String userName = token[0];
            Long tokenTime = Long.valueOf(token[1]);
            Long lastLoginTime = userService.query(userName).getLoginAt();
            if (!tokenTime.equals(lastLoginTime))
                throw new XSSException("该Session的信息可能存在异常！");
            result = true;
        }
        return result;
    }
}

