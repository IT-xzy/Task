package com.mutesaid.utils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用于拦截所有请求显示右上角信息
 *
 * @author TwT
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Cookie[] cookies = request.getCookies();

        Map<String, String> msgList = new LinkedHashMap<>(2);

        Boolean isLogin = CookieUtil.isLogin(cookies);

        if (isLogin) {
            Map tokenMap = CookieUtil.getTokenMap(cookies);
            String key = "欢迎 ! " + tokenMap.get("usrName");

            msgList.put(key, "home");
            msgList.put("退出", "logout");
            modelAndView.addObject("msgList", msgList);
        } else {
            msgList.put("登录", "loginPage");
            msgList.put("注册", "signupPage");
            modelAndView.addObject("msgList", msgList);
        }
    }
}
