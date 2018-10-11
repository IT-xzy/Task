package com.jns.interceptor;

import com.jns.service.UsersService;
import com.jns.utils.DESUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        logger.info("Cookie长度为: {}" ,cookies.length);
        logger.info("拦截器获取到的Cookie:{} " , String.valueOf(cookies));
        if (cookies != null) {
            logger.info("开始遍历");
            // 遍历
            for (Cookie cookie : cookies) {
                logger.info("当前cookie的值: {},名字为:{}" , cookie.getValue() ,cookie.getName());
                // 判断是否有token
                if (cookie.getName().equals("token")) {
                    String base64token = cookie.getValue();
                    logger.info("token的base64加密value : {}" , base64token);
                    String DEStoken = DESUtil.toHexString(Base64.decodeBase64(base64token)).toUpperCase();
                    logger.info("token的去除base64后的加密value: {}" , DEStoken);
                    String token = java.net.URLDecoder.decode(DESUtil.decrypt(DEStoken, "liuhuan1"), "utf-8");
                    logger.info("token的解密value:{}" , token);
                    // 分割字符串 获取id
                    long id = Integer.valueOf(token.split("=")[0]);
                    logger.info("id为: {}" , id);
                    return true;
                }
                if(cookie.getName().equals("phone")){
                    return true;
                }
            }
            httpServletResponse.sendRedirect( "/login");
            return false;
        }
        return false;
    }
}




