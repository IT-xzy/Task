package com.Interceptor;

import com.util.JWT;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Cookie[] cookies = request.getCookies();
        String name = null;
        String password = null;
        if (cookies.length == 0) {
            logger.info("你没有cookie信息");
        } else {
            for (Cookie cookie : cookies) {
                logger.info("cookie.getValue()里面有那些信息" + cookie.getValue());
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    logger.info("nameCookie的值value是" + token);
                    if (JWT.parseJWT(token) != null)
                        logger.info("验证成功");
                    return true;
                }
            }
        }
        response.sendRedirect("/student");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
