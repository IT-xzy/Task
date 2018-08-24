package com.Cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class cookieTool {
    //创建Cookie
    public static void addCookie(HttpServletResponse response,String name ,String value ,int maxAge){
        Cookie cookie =new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge>0){
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static Cookie getCookieName(HttpServletRequest request ,String name){
        Map<String,Cookie> cookieMap =ReadCookie(request);
        if (cookieMap.containsKey(name)){
            Cookie cookie =cookieMap.get(name);
            return cookie;
        }
        else {
            return null;
        }
    }

    public  static Map<String,Cookie> ReadCookie(HttpServletRequest request) {
    Map<String,Cookie> cookieMap = new HashMap<String, Cookie>();
    Cookie[] cookies =request.getCookies();
    if (cookies!=null){
        for (Cookie cookie:cookies){
            cookieMap.put(cookie.getName(),cookie);
        }
    }
    return cookieMap;
    }
}
