package com.jnshu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 测试结果:
*
* 拦截器1放行，拦截器2 preHandle才会执行。
* 拦截器2 preHandle不放行，拦截器2 postHandle和afterCompletion不会执行。
* 只要有一个拦截器不放行，postHandle不会执行。
*
* */

//测试拦截器
public class HandlerInterceptor1 implements HandlerInterceptor{
    //日志
    private static Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("HandlerInterceptor1 preHandle 拦截器执行了 ");

        //return false表示拦截，不向下执行
        //return true表示放行
        return true;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("HandlerInterceptor1 postHandle 拦截器执行了");
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("HandlerInterceptor1 afterCompletion 拦截器执行了");
    }
}
