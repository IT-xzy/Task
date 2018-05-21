package com.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetcookieByName {

    public static String dogetvalue(HttpServletRequest httpServletRequest,String name){
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals(name)){
                    String value = cookie.getValue();
                    return value;
                }
            }
        }
        return null;
    }

    public static Cookie dogetcookie(HttpServletRequest httpServletRequest,String name){
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
