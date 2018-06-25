package com.oto.util;

import com.oto.dao.userDao;
import com.oto.pojo.user;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/14 上午11:07
 */

public class Interceptor implements HandlerInterceptor {
    
    @Autowired
    userDao Mapper;
    private static final String SKEY = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String loginCookieUserName;

//        得到cookie
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            
            if ("name".equals(cookie.getName())) {
                loginCookieUserName = cookie.getValue();
                String username;
                String time;
                loginCookieUserName = DesUtil.decrypt(loginCookieUserName, CHARSET, SKEY);
                String[] userParams = loginCookieUserName.split("\\|");
                username = userParams[0];
                time = userParams[1];
                long oldTime = Long.parseLong(time);
                long nowTime = System.currentTimeMillis();
                user userDB = Mapper.selectByName(username);
                if (nowTime - oldTime < 30 * 60 * 1000 || nowTime - oldTime > 0) {
                    if (username.equals(userDB.getUsername())) {
                        return true;
                        
                    }
                }
            }
            
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
        
    }
    
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    
    }
}
