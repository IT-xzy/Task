package com.xiaobo.demo.interceptor;


import com.xiaobo.demo.util.CookieUtil;
import com.xiaobo.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        String JwtToken = cookieUtil.getCookie(request);
        if(JwtToken == null) {
            System.out.println("尚未登录，跳转到登录页面");
            response.sendRedirect("/a/login");
            return  false;
        }
        Long userId = jwtUtil.getUserId(JwtToken);
        if(userId == null){
            System.out.println("jwt解析失败");
            response.sendRedirect("/a/login");
            return  false;
        }
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(userId);
        return  true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        System.out.println("postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

}
