package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
     Cookie[] cookies= httpServletRequest.getCookies();
     if(cookies!=null){
         //比对cookie
         for (int i=0;i<cookies.length; i++){
             Cookie cookie=cookies[i];
             if (cookie.getName().equals("name")){
                 System.out.println("拦截器： 已拦截，放行，登录成功");
                 return true;
             }else {
                 httpServletResponse.sendRedirect("/h1");
                 return false;
             }
         }

     }else {
         httpServletResponse.setHeader("Location", "/h1");
         httpServletResponse.setStatus(302);
         return  false;
     }
        httpServletResponse.sendRedirect("/h1");
        return false;
    }

    @Override
    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
