package com.mutesaid.utils;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CookieUtil {
    private static final String JWT_KEY = "www.jnshu.com";

    public static Cookie addCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(10 * 60);
        cookie.setPath("/");
        return cookie;
    }

    public static Cookie killCookie(String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }

    public static Boolean isLogin(Cookie[] cookies) {
        if (cookies == null) {
            return false;
        } else {
            return Arrays.stream(cookies)
                    .filter(cookie -> "token".equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .anyMatch(CookieUtil::isTrueToken);
        }
    }

    public static Map getTokenMap(Cookie[] cookies) {
        List<String> jwt = Arrays.stream(cookies)
                .filter(cookie -> "token".equals(cookie.getName()))
                .map(Cookie::getValue).collect(Collectors.toList());
        return getTokenMap(jwt.get(0));
    }

    private static Map getTokenMap(String token) {
        return JJWTUtil.verify(token, JWT_KEY);
    }

    public static String getUsr(Cookie[] cookies) {
        Map usrMap = getTokenMap(cookies);
        return usrMap.get("usrId").toString();
    }

    private static Boolean isTrueToken(String token) {
        return getTokenMap(token) != null;
    }
}
