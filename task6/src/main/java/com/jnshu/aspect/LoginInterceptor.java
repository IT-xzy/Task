package com.jnshu.aspect;


import com.jnshu.myutils.DESUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        logger.info("cookies==="+Arrays.toString(cookies));
        if(cookies==null||cookies.length == 0){
            logger.info("没有cookie==========");
        }else{
            logger.info("有cookie==========");
            String name = "";
            String token ;
            // 遍历cookie如果找到登录状态则返回true执行原来controller的方法
            for(Cookie cookie:cookies){
                logger.info("cookie.name====="+cookie.getName());
                logger.info(cookie.getName().equals("name"));
                if(cookie.getName().equals("name")){
                    logger.info("验证成功,cookie.value:" + cookie.getValue());
                    //在页面显示登陆用户
                    name = cookie.getValue();
                    // request.getSession()可以帮你得到HttpSession类型的对象，
                // 通常称之为session对象，session对象的作用域为一次会话，通常浏览器不关闭，保存的值就不会消失
                /*session.setAttribute("key",value)；是session设置值的方法，
                原理同java中的HashMap的键值对，意思也就是key现在为“name”；存放的值为从cookie中取出的值*/
                //                    httpServletRequest.getSession().setAttribute("name",name);
                 //   logger.info("name========="+name);
                  //  return true;
                }
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                    logger.info(token);
                    DESUtil desUtil = new DESUtil();
                    String str = desUtil.decrypt(token);

                    logger.info(str);
                    String name2 = str.split("\\|" )[1];
                    logger.info(name2);
                    if(name.equals(name2)){
                    httpServletRequest.getSession().setAttribute("name", name);
                    return true;
                    }
                }
            }
        }
        //没有找到登陆状态则重定向到登录页，返回false,不执行原来controller中的方法
        logger.info("httpServletResponse.sendRedirect(\"/login\");");
        httpServletResponse.sendRedirect("/task6/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
