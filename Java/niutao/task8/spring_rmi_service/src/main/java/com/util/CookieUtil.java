package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(CookieUtil.class);

    public static Cookie getCookieByName(HttpServletRequest httpServletRequest,String name){
        Cookie[] cookies =httpServletRequest.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static String getValueByName(HttpServletRequest httpServletRequest,String name){
        Cookie cookie = getCookieByName(httpServletRequest,name);
        if (cookie!=null){
            return cookie.getValue();
        }else
            return "";
        }

    public static String getId(HttpServletRequest httpServletRequest){
        return getValueByName(httpServletRequest,"id");
    }

}
