package com.ptteng.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptteng.pojo.exception.ForbiddenException;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.utils.CookieUtil;
import com.ptteng.utils.DataCheckUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Objects;

public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (CookieUtil.checkTokenCookie(request,response)) {
            return true;
        }
        //跳转前判断方法
        String method = request.getMethod();
        if (!Objects.equals(method, "GET")) {
            throw new ForbiddenException("未登录的情况下尝试修改数据，url:" + request.getPathInfo());
        }
        request.getRequestDispatcher("/a/login").forward(request, response);
        return false;
    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }


}

