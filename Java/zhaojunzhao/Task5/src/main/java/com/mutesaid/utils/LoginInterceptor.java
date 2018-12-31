package com.mutesaid.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TwT
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LogManager.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        Boolean isLogin = CookieUtil.isLogin(cookies);

        if (isLogin) {
            logger.info("token验证通过");
            return true;
        } else {
            logger.info("token验证未通过");
            response.sendRedirect("/Tiles/loginPage");
            return false;
        }
    }
}
