package com.ptteng.Interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description 利用spring框架提供的HandlerInterceptorAdapter，实现自定义拦截器
 * @Author 孙若飞
 * @Date 2019/2/16  10:47
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(HandlerInterceptor.class);


    //在请求之前被调用,
    //重写preHandle方法，返回的是true，继续下面的方法；如果返回的是false，请求结束

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//   请求cookie里的信息,放入cookies
        Cookie[] cookies = httpServletRequest.getCookies();

//如果cookies的长度等于0,表示没有cookies,返回登录页面,让用户登录一下下,发给用户一个cookie,下次光临的时候用户就有cookie了
        if (cookies.length == 0) {
            logger.info("no cookie oh~~~~~~~~~~~~~~~~~~");
        } else {
//     用户有cookies
            logger.info("there you are !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! my little cookie");

            //遍历一下用户的cookies,放入cookie,看看他的cookie是什么呀
            for (Cookie cookie : cookies) {
                //如果他的cookie与我发给他的cookie相等,就可以直接返到页面里
                if (cookie.getName().equals("name")) {
                    logger.info("name is:" + cookie.getValue());
                    if (cookie.getName().equals("token")){
                    logger.info("token is "+cookie.getValue());
                    }

                   return true;

                }
            }
        }
//        返回登录页面
        httpServletResponse.sendRedirect("/login");
        return false;
    }

    //在业务处理器处理请求完成之后,生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
