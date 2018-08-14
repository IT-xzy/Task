package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

public static Cookie getCookie(String cookieName, HttpServletRequest request){
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    if(cookies!=null){
        for (int i=0;i<cookies.length;i++){
            if (cookies[i].getName().equals(cookieName)){
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
