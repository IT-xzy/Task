package com.interceptor;

import com.Impl.LoginServiceImpl;
import com.Utils.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 登录拦截器
 * @create: 2018/5/9 下午3:39
 */

public class LoginInterceptor implements HandlerInterceptor {
    public static Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    LoginServiceImpl loginServiceImpl;
    
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exc) throws Exception {
        
    }
    
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        
    }
    
    //获取请求的URL
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        
        
        String url = request.getRequestURI();
        String contextpath = request.getContextPath();
        
        logger.info("这是请求的url：" + url + "..." + contextpath);
        
        String subject = JwtUtil.getSubject(request, "JWT_COOKIE", "mysignkey1");
        if (null == subject) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        String namess = loginServiceImpl.findUserByName(subject);
        if (null == namess) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
