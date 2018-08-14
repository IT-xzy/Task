package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void createCookie(String key,String value, HttpServletResponse response){
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(key,value);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.addCookie(cookie);
    }

    public static void deleteCookie(String key,String value, HttpServletResponse response){
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(key,value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.addCookie(cookie);
    }
    public static Cookie getCookie(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies!=null){
            for (int i=0;i<cookies.length;i++){
                if (cookies[i].getName().equals(name)){
                    cookie = cookies[i];
                    break;
                }else {
                    cookie = null;
                }
            }
        }
        return cookie;
    }
}