package com.ptt.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CookieUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/12 18:01
 * @Version: 1.0
 */
@Component
public class CookieUtil {
    private static int maxAge;
    private static String path;
    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    @Value("${maxAge}")
    public void setMaxAge(String maxAge) {
        CookieUtil.maxAge = Integer.parseInt(maxAge);
    }

    @Value("${path}")
    public void setPath(String path) {
        CookieUtil.path = path;
    }

    public static void addCookie(HttpServletResponse response, Cookie cookie){
        if(null !=cookie)
            response.addCookie(cookie);
    }

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue){
        if(null != cookieName && !cookieName.equals("")){
            if(null == cookieValue)
                cookieValue = "";
            Cookie cookie = new Cookie(cookieName, cookieValue);
            logger.info("cookieValue:" + cookie.getValue());
            if(maxAge > 0)
                cookie.setMaxAge(maxAge);
            if(null == path)
                cookie.setPath("/");
            else cookie.setPath(path);
            addCookie(response, cookie);
        }
    }

    public static Cookie getCookieByName(HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        if(null == cookieName || cookieName.equals("") || null == cookies)
            return null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(cookieName))
                return cookie;
        }
        return null;
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName){
        Cookie cookie = getCookieByName(request, cookieName);
        if(null == cookie)
            return null;
        else return cookie.getValue();
    }

    public static void deleteCookie(HttpServletResponse response, Cookie cookie){
        if(null != cookie){
            cookie.setValue(null);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName){
        Cookie cookie = getCookieByName(request, cookieName);
        if(null != cookie && cookie.getName().equals(cookieName))
            deleteCookie(response, cookie);
    }

    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                  String cookieValue){
        Cookie cookie = getCookieByName(request, cookieName);
        if(null != cookie && null != cookieName && !cookieName.equals("") && !cookie.getName().equals(cookieName))
            addCookie(response, cookieName, cookieValue);
    }
}
