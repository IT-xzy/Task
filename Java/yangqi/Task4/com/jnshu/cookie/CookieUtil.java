package com.jnshu.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;



public class CookieUtil {




    //设置接口
    //创建cookie

    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */

    public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }
    //得到cookie的name
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookie(request);
        if (cookieMap.containsKey(name)){
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        }else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookie(HttpServletRequest request) {
        Map<String , Cookie> cookieMap = new HashMap<String ,Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null!=cookies){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;

    }
}
