package com.jnshu.Login;


import com.jnshu.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginInterceptor implements HandlerInterceptor {

    @Autowired
    public StudentService service;

    private static Logger logger = LoggerFactory.getLogger(loginInterceptor.class);

    //执行handler方法之前执行
    //用于身份认证，身份授权
    //比如身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)throws Exception{


        String url = httpServletRequest.getRequestURI();
        logger.debug("进入拦截器");
        //判断url是否是公开使用的（实际使用时将公开地址配置到配置文件中）
        //可以导入一个配置文件，匹配其中的请求
        //indexof()判断是否包含某字符串

        //这里放通通两个 一个login 一个 登陆
        if (url.indexOf("login")>0 || url.indexOf("doLogin")>0 || url.indexOf("register")>0 || url.indexOf("Register")>0 || url.indexOf("home")>0) {
            logger.info("url 放通");
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        String name = (String )session.getAttribute("name");
        logger.info("显示name" + name);
        if (name != null) {
            logger.debug("name 不为空");
            //登陆成功的用户
            //判断session
//            httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(httpServletRequest,httpServletResponse);
            return true;
        } else {
            //这里是将请求转发到指定的url，所以该请求能够直接获得上一个请求的数据，也就是说采用请求不转发，request对象始终存在，不会重新创建

        }
        //判断session
//        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);

        //这里写的是访问的登陆的url
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/login" );
        return false;
    }
    //进入handler 方法之后，返回modelAndview之前执行
    //应用场景从modelAndView出发：将公用的模型数据（菜单导航）在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)throws Exception{
        logger.info("test postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }
    //执行handler完成执行此方法
    //应用场景:统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e)throws Exception{
        logger.info("HandlerInterceptor1 afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
    }
}
