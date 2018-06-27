package com.restful.controller;

import com.restful.model.User;
import com.restful.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginIntercetptor implements HandlerInterceptor {

    @Autowired
    private UserServiceImpl userService;

    @Value("SSO_USER_URL")
    private String SSO_USER_URL;

//    preHandler ：在进入Handler方法之前执行了，使用于身份认证，身份授权，登陆校验等，
// 比如身份认证，用户没有登陆，拦截不再向下执行，返回值为 false ，即可实现拦截；否则，返回true时，拦截不进行执行；
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        测试

        return true;
    }

//    postHandler : 进入Handler方法之后，返回ModelAndView之前执行，使用场景从ModelAndView参数出发，
// 比如，将公用的模型数据在这里传入到视图，也可以统一指定显示的视图等；
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }
//    afterHandler : 在执行Handler完成后执行此方法，使用于统一的异常处理，统一的日志处理等；
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
