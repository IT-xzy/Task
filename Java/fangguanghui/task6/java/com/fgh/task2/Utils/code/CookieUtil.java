package com.fgh.task2.Utils.code;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class CookieUtil {



    /**
     * 将cookie放入map中，方便通过name来获取value
     * @param request
     * @return
     */
    private static Map ReadCookieMap(HttpServletRequest request){
        Map cookieMap=new HashMap();
        Cookie[] cookies=request.getCookies();
        if (null!=cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 根据name 来获取cookie
     * @param request
     * @param name
     * @return
     */
    public static String getToekn(HttpServletRequest request,String name){
        Map cookieMap=ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
          Cookie cookie = (Cookie) cookieMap.get(name);
          String token = cookie.getValue();
          return token;
        }
        else
            return null;
    }

    /**
     * 根据name 来获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request,String name){
        Map cookieMap=ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        }
        else
            return null;
    }

    /**
     * 添加新的cookie
     * @param cookieName
     * @param cookieValue
     * @param maxAge
     * @param response
     */
    public static Cookie addCookie(String cookieName,String cookieValue,
                                  int maxAge,HttpServletResponse response,
                                   HttpServletRequest request){
        Cookie cookie=new Cookie(cookieName,cookieValue);
        cookie.setPath(request.getContextPath());
        if (0!=maxAge)
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        return cookie;
    }

    public static void delCookie(HttpServletResponse respone,
                                  String name,HttpServletRequest request){
        Cookie cookie = getCookie(request,name);
        if (cookie!= null){
            cookie.setMaxAge(0);
            respone.addCookie(cookie);
        }

    }
}
