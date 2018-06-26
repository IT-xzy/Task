package com.task.interceptor;

import com.task.entity.User;
import com.task.entity.UserToken;
import com.task.service.UserService;
import com.task.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManageInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userServivce;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取cookie
        Cookie[] cookies = request.getCookies();

        for(Cookie cookie : cookies){
            //获取token
            if(cookie.getName().equals("token")) {

                String token = cookie.getValue();
                System.out.println("token+++"+token);

                UserToken userToken = JwtUtil.unsign(token, UserToken.class);
                System.out.println("test+++"+userToken);

                if(null!=userToken.getName() && null!=userToken.getPswd()){
                    //查找是否存在该用户
                    User user = userServivce.checkLogin(userToken.getName(), userToken.getPswd());
                    if(null != user){
                        //用户已经登录
                        System.out.println("用户已登录"+userToken.getPswd());
                        return true;
                    }
                }
            }

        }

        System.out.println("用户未登录");
        request.getRequestDispatcher("/user/login").forward(request, response);
        return false;


    }
}
