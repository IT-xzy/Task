package cn.summerwaves.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    private static Map<String, Cookie> ReadCooKieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCooKieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = cookieMap.get(name);
            return cookie;
        }
        return null;
    }

    public static Cookie createCookie(String name, String value, Integer expire) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(name.trim(), URLEncoder.encode(value.trim(),"UTF-8"));
        cookie.setMaxAge(expire);
        cookie.setPath("/");
        return cookie;
    }

    public static String getCookieValueByName(HttpServletRequest request,String name) throws UnsupportedEncodingException {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null && StringUtils.isNotBlank(cookie.getValue())) {
            return URLEncoder.encode(cookie.getValue(), "UTF-8");
        } else if (cookie.getValue() != null) {
            return "";
        } else {
            return null;
        }
    }

    public static Cookie modCookieByName(HttpServletRequest request, String name,String value, Integer expire, boolean creatd) throws UnsupportedEncodingException {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null) {
            cookie.setMaxAge(expire);
            cookie.setValue(URLEncoder.encode(value, "UTF-8"));
        } else{
            if (creatd) {
                cookie = createCookie(name, value, expire);
            }

        }
            return cookie;
    }

}
