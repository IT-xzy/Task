package com.jnshu.tiles.interceptor;

import com.jnshu.tiles.tools.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Tiles
 * @description: 测试登录验证
 * @author: Mr.Lee
 * @create: 2018-07-08 10:53
 **/
public class LoginInterceptor1 implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        if (httpServletRequest.getServletPath().endsWith("profession")){
            logger.info("请求已进入拦截器！");

            Cookie cookies = CookieUtil.getCookieByName(httpServletRequest,"token");

            logger.info("cookies :" + cookies);
            if (cookies == null){
                logger.info("用户还未登录或cookie已失效，需重新登录!");
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/viewLogin");
                return false;
            }
            //如果cookie存在，直接登录
            String tokens = cookies.getValue();
            logger.info("tokens:"+tokens);
            logger.info("token有效，用户可以登录！");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
