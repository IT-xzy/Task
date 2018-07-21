package com.jnshu.tiles.tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Tiles
 * @description:
 * @author: Mr.Lee
 * @create: 2018-07-05 23:54
 **/
public class CookieUtil {

    /**
    * @Description: 创建cookie
    * @Param: [cookieName, cookieValue]
    * @return: javax.servlet.http.Cookie
    * @Author: Mr.Lee
    * @Date: 2018\7\5 0005
    */
    public static Cookie getLoginCookie(String cookieName,String cookieValue){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(60*30);
        return cookie;
    }

    /** 
    * @Description: 根据cookieName删除cookie
    * @Param: [request, cookieName] 
    * @return: javax.servlet.http.Cookie 
    * @Author: Mr.Lee
    * @Date: 2018\7\5 0005 
    */ 
    public static Cookie deleteCookieByName(HttpServletRequest request,String cookieName){
        Cookie cookie = getCookieByName(request,cookieName);
        if (cookie == null){
            return null;
        }
        
        cookie.setPath("/");
        cookie.setValue(null);
        cookie.setMaxAge(0);
        return cookie;
    }

    /**
    * @Description: 根据cookieName获取cookie
    * @Param: [request, cookieName]
    * @return: javax.servlet.http.Cookie
    * @Author: Mr.Lee
    * @Date: 2018\7\6 0006
    */
    public static Cookie getCookieByName(HttpServletRequest request,String cookieName){
        Map<String ,Cookie> map = getCookieMap(request);
        if (map.containsKey(cookieName)){
            return map.get(cookieName);
        }
        else {
            return null;
        }
    }

    
    /** 
    * @Description: 封装cookie进Map 
    * @Param: [request] 
    * @return: java.util.Map<java.lang.String,javax.servlet.http.Cookie> 
    * @Author: Mr.Lee
    * @Date: 2018\7\6 0006 
    */ 
    private static Map<String ,Cookie> getCookieMap(HttpServletRequest request){
        Map<String ,Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies !=null){
            for (Cookie cookie:cookies){
                map.put(cookie.getName(),cookie);
            }
        }
        return map;
    }

}
