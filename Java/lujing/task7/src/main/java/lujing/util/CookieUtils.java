package lujing.util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lujing
 * Create_at 2018/1/6 13:51
 */
public class CookieUtils {
    /**
     * 生成cookie
     *
     * @param response
     * @param name     cookie的名字
     * @param value    cookie的值
     * @param MaxAge   cookie最大保存时间
     */
    public static void createCookie(HttpServletResponse response, String name, String value, int MaxAge) {
        
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(MaxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    /**
     * 清除cookie:设置放置TOKEN的cookie为空。
     *
     * @param response
     * @param name
     */
    public static void clearCookie(HttpServletResponse response, String name) {
        
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        
        response.addCookie(cookie);
    }
    
    /**
     * 根据cookie名字遍历出cookie的值
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = WebUtils.getCookie(request,name);
        
        if(null == cookie){
            return null;
        }
        
        return cookie.getValue();
    }
}
