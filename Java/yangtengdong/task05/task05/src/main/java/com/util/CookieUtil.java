package com.util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: CookieUtil
 * @description: Cookie工具类
 * @author: ytd
 * @create: 2018-08-29 23:37
 **/
public class CookieUtil {
    //设置最长过期时间 COOKIE_MAX_AGE
    public static final int COOKIE_MAX_AGE = 7 * 24 * 3600;
    public static final int COOKIE_HALF_HOUR = 30 * 60;

    /**
    * @Description: 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
    * @Param: [request, name]
    * @return: javax.servlet.http.Cookie
    * @Author: ytd
    * @Date: 30/08/2018
    */

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (null == name || name.equals("") || null == cookies) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                cookie = c;
                break;  //当找到名字一样的cookie时,就终止寻找,节约资源
            }
        }
        return cookie;
    }

    /**
     * @Description: 根据Cookie名称直接得到Cookie值
     * @Param: [request, name]
     * @return: java.lang.String
     * @Author: ytd
     * @Date: 30/08/2018
     */

    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if(cookie != null){
            return cookie.getValue();
        }
        return null;
    }

    /**
    * @Description: 移除cookie
    * @Param: [request, response, name]
    * @return: void
    * @Author: ytd
    * @Date: 30/08/2018
    */

    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response, String name) {
        if (null == name) {
            return;
        }
        Cookie cookie = getCookie(request, name);
        if(null != cookie){
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
    * @Description: 添加一条新的Cookie，可以指定过期时间(单位：秒)
    * @Param: [response, name, value, maxValue]
    * @return: void
    * @Author: ytd
    * @Date: 30/08/2018
    */

    public static void setCookie(HttpServletResponse response, String name,
                                 String value, int maxValue) {
        if (null == name || name.equals("")) {
            return;
        }
        if (null == value) {
            value = "";
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxValue != 0) {
            cookie.setMaxAge(maxValue);
        } else {
            cookie.setMaxAge(COOKIE_HALF_HOUR);
        }
        response.addCookie(cookie);
        try {
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * @Description: 添加一条新的Cookie，默认30分钟过期时间
    * @Param: [response, name, value]
    * @return: void
    * @Author: ytd
    * @Date: 30/08/2018
    */

    public static void setCookie(HttpServletResponse response, String name,
                                 String value) {
        setCookie(response, name, value, COOKIE_HALF_HOUR);
    }

    /**
    * @Description: 将cookie封装到Map里面
    * @Param: [request]
    * @return: java.util.Map<java.lang.String,javax.servlet.http.Cookie>
    * @Author: ytd
    * @Date: 30/08/2018
    */

    public static Map<String,Cookie> getCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
