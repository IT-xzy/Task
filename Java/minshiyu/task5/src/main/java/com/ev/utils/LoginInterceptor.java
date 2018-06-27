package com.ev.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        JWTUtil jwtUtil = new JWTUtil();
        /*
         * 从cookie中获取信息
         */
        Cookie[] cookies = request.getCookies();
        for (Cookie cooky : cookies) {
            if ((cooky.getName()).compareTo("mytoken") == 0) {
                String token = cooky.getValue();
                DecodedJWT jwt = jwtUtil.decodeToken(token);
                if (jwt.getToken().equals(token) && jwt.getExpiresAt().getTime()>System.currentTimeMillis()) {
                    return true;
                }
            }
        }
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }
}
