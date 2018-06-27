package com.longhang.userHandler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class UserHandler implements HandlerInterceptor {
    // 在业务处理器处理请求之前，生成视图之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        return true;
    }
    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView modelAndView)throws Exception{

    }
    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex)throws Exception{

    }
}
