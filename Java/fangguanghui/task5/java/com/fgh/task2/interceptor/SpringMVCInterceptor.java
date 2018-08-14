package com.fgh.task2.interceptor;

import com.fgh.task2.Utils.CookieUtil;
import com.fgh.task2.Utils.TokenUtil;
import com.fgh.task2.service.loginService.LoginService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

public class SpringMVCInterceptor implements HandlerInterceptor {
    @Autowired
    LoginService loginService;

    Logger logger=LogManager.getLogger(SpringMVCInterceptor.class.getName());
    /**
     * preHandle 在controller调用之前调用，如果有多个拦截器，会按声明拦截器的
     * 的前后顺序一个一个执行
     * 返回false表示请求结束，后续的拦截和controller都不会执行

     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,Object handler)throws Exception{
        //判断当前请求链接中是否包含login，
        String url=request.getRequestURI();
        if (url.indexOf("index")>=0)
            return true;

        Cookie token=CookieUtil.getCookie(request,"token");
        if (token!=null){
            String tokenValue=token.getValue();
            String tokenData=TokenUtil.decrypt(tokenValue);
            String[] s_token=tokenData.split("/");
            String id=s_token[0];
            Long userid=Long.parseLong(id);
            //输出用户id
            logger.debug("id:"+userid);
            if (loginService.quaryById(userid))
                return true;

        }
        //验证失败，返回登录界面
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
        logger.debug("登录失败");
        return false;
    }

    /**
     * 在controller方法调用之后调用，但是会在视图渲染之前执行
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 前端控制器渲染视图之后执行，主要用于清理资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
