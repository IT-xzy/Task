package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类，用来添加、获取、删除cookie
 */
public class CookieUtil {
    /**
     * 添加cookie
     * @param response http响应
     * @param name cookie name
     * @param value cookie value
     */
    public static void addCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(60*60); //cookie保存60min
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     * @param response http响应
     * @param name cookie name
     */
    public static void removeCookie(HttpServletResponse response,String name){
        Cookie cookie = new Cookie(name,null);
        cookie.setPath("/");
        cookie.setMaxAge(0); //0是立即删除，-1是关闭后删除
        response.addCookie(cookie);
    }

    /**
     * 通过cookieName 获取cookieValue
     * @param request http请求
     * @param name cookieName
     * @return value
     */
    public static String getValue(HttpServletRequest request, String name){
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie :cookies){
            if (cookie.getName().equals(name))
                return cookie.getValue();
        }
        return null;
    }
}
