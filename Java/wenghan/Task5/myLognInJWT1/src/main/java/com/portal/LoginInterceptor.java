package com.portal;

import com.encryption.*;
import com.pojo.SignIn;
import com.pojo.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//自定义拦截器，必须实现HandlerInterceptor接口(拦截器)
public class LoginInterceptor implements HandlerInterceptor {

    //controller的前置方法，当方法返回false整个请求就结束了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //首先进入的方法
        //return false表示拦截，不向下执行
        //return true表示放行
        System.out.println(request.getServletPath());
        String jwt=null;
        //从Cookie中获得JWT
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("JWT")){
                    jwt=cookie.getValue();
                }
            }
        }
        //调用改写好的判定JWT可靠性的方法
        if(jwt!=null){
            SignIn signIn=JWT.unsign(jwt,SignIn.class);
            System.out.println(signIn);
            //放行
            return true;
        }
        //Cookie中无登录状态则重定向到登录控制器
        response.sendRedirect("/Login");
        return false;
    }

    //返回modelAndView之前执行
    //在当前请求进行处理之后，也就是Controller方法调用之后执行，
    // 但是它会在DispatcherServlet进行视图返回渲染之前被调用。
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    //该方法将在整个请求结束之后，也就是在DispatcherServlet
    // 渲染了对应的视图之后执行,可用于清理资源。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

