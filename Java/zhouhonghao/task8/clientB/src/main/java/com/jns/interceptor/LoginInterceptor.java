package com.jns.interceptor;

import com.jns.utils.DESUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
    //拦截页面，
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        HttpSession session=httpServletRequest.getSession();
        if (cookies != null) {
            // 遍历
            for (Cookie cookie : cookies) {
                // 判断是否有token
                if (cookie.getName().equals("token")) {
                    String token=cookie.getValue();
                    String localToken= (String) session.getAttribute("token");
                    if(token.equals(localToken)){
                    String base64token = cookie.getValue();
                    String DEStoken = DESUtil.toHexString(Base64.decodeBase64(base64token)).toUpperCase();
                    return true;
                    }
                }
            }
            httpServletResponse.sendRedirect( "/login");
            return false;
        }
        return false;
    }
}




