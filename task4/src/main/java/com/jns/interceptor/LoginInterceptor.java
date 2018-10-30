package com.jns.interceptor;

import com.jns.service.UsersService;
import com.jns.utils.DESUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        System.out.println("Cookie长度为: " + cookies.length);
        System.out.println("拦截器获取到的Cookie: " + String.valueOf(cookies));
        if (cookies != null) {
            System.out.println("开始遍历");
            // 遍历
            for (Cookie cookie : cookies) {
                System.out.println("当前cookie的值: " + cookie.getValue() + " 名字为:" + cookie.getName());
                // 判断是否有token
                if (cookie.getName().equals("token")) {
                    String base64token = cookie.getValue();
                    System.out.println("token的base64加密value : " + base64token);
                    String DEStoken = DESUtil.toHexString(Base64.decodeBase64(base64token)).toUpperCase();
                    System.out.println("token的去除base64后的加密value: " + DEStoken);
                    String token = java.net.URLDecoder.decode(DESUtil.decrypt(DEStoken, "liuhuan1"), "utf-8");
                    System.out.println("token的解密value:" + token);
                    // 分割字符串 获取id
                    long id = Integer.valueOf(token.split("=")[0]);
                    System.out.println("id为: " + id);
                    return true;
                }
            }
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return false;
        }
        return false;
    }
}




