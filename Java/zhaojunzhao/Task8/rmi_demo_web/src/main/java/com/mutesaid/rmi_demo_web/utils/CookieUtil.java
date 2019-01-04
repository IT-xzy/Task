package com.mutesaid.rmi_demo_web.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 */
@Slf4j
public class CookieUtil {

    public static final String UID = "UID";

    public static Long getUid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(UID)) {
                Long uid =  JJWTUtil.getUID(cookie.getValue());
                log.info("uid = {}", uid);
                return uid;
            }
        }
        return 0L;
    }

    //退出登录时，清空cookie
    public static void loginout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(UID)) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }

    }

}



