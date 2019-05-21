package com.jnshu.interceptor;

import com.jnshu.pojo.tool.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        JwtUtil jwtUtil = new JwtUtil();
        //获取请求的RUi:去除http:localhost:8080这部分之后的部分
        String url = httpServletRequest.getRequestURI();
        System.out.println("url = " + url);
        //获取request的cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null){
            System.out.println("用户未登陆，验证失败");
        }else
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    return true;
                }
            }
        }
        // 没有找到登录状态则重定向到登录页，返回false，不执行原来controller的方法
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpServletResponse.getWriter().write("未登录，请重新登录后操作");
        httpServletRequest.getRequestDispatcher("/goLogin").forward(httpServletRequest, httpServletResponse);
        return false;

    }

    //在业务处理器处理请求完成之后,生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception{
    }
    //在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception{
    }
}
