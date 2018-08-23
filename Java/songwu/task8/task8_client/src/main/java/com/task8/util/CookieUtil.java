package com.task8.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Create by SongWu on 2018/7/5
 */
public class CookieUtil {


    public static Cookie getCookie(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");
        return cookie;
    }


    public static Cookie deleteCookie(HttpServletRequest request, String cookieName) {
      Cookie c=  CookieUtil.getCookieByName(request, cookieName);
      if(c!=null){
        c.setValue(null);
        c.setMaxAge(0);
        c.setPath("/");

          return c;
      }
return null;
    }


    public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie cookie;


        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (cookieName.equals(c.getName()) ) {

             cookie=c;
             return cookie;
            }

        }
        return null;
    }
}