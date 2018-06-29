package com.opt.controller;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.opt.service.impl.UserServiceImpl;
import com.opt.util.DESUtil;
import com.opt.util.JWTUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Nullable;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @Title: 登录拦截器
 * @Description: 拦截登录 判断session token 匹配用户
 * @author By.ZhangQiang
 * @date 2018-5-26 16:16
 */

@Controller
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = Logger.getLogger(LoginInterceptor.class);
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");

    private final String TOKENKEY = "zhangqiang";

//    preHandle在业务处理器处理请求之前被调用 前置方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getRequestURI();

        logger.info("\n拦截器开始拦截请求  拦截url:" + url + ",查询是否放行\n");

//        如果url包含profession则拦截 或者使用是否处在页面indexOf("profession") url.indexOf("profession")>=0
//        url.contains("name") 是否包含name
        if(!url.contains("login")){

            if(url.contains("reg")){
                logger.info("\n注册页面 reg 拦截器放行\n");
                return true;
            }
            if(url.contains("smsCode")){
                logger.info("\n发送验证短信  拦截器放行\n");
                return true;
            }
            if(url.contains("emailCode")){
                logger.info("\n发送验证邮箱 拦截器放行\n");
                return true;
            }

//            查找cookie
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    if(cookie.getValue()!=null){

                        try{
                        Date date = new Date();

                        JWTUtil jwtUtil = new JWTUtil(TOKENKEY);

                        String token = cookie.getValue();
                        DecodedJWT jwt = null;

                        try{

                            jwt = jwtUtil.decodedToken(token);

                        }catch (RuntimeException e){
                            logger.info(e.getMessage());
                            logger.info("token过期");
                            request.setAttribute("message","请登录后查看");
                            request.getRequestDispatcher("login").forward(request,response);
                            return false;
                        }
                        //test

//                    logger.info("\n当前时间："+(date.getTime()));
//                    logger.info("\n过期时间："+(jwt.getExpiresAt().getTime()));
//                    logger.info("\n是否过期："+(date.getTime()<jwt.getExpiresAt().getTime()));
//                    logger.info("\n签发者是否正确："+jwt.getIssuer().toString().equals("张强"));
//                    logger.info("\n是否不为空："+(userService.findByName(jwt.getClaim("name").asString())!=null));

                        if(date.getTime()<jwt.getExpiresAt().getTime() && jwt.getIssuer().toString().equals("张强") && userService.findByName(jwt.getClaim("name").asString())!=null){
                            logger.info("\ntoken有效");
                            String newToken = jwtUtil.createToken(jwt.getClaim("name").asString(),7*24*60);
                            Cookie cookie1 = new Cookie("token",newToken);
                            response.addCookie(cookie1);
                            HttpSession session = request.getSession();
                            session.setAttribute("username",jwt.getClaim("name").asString());
                            return true;
                        }

                        logger.info("\ntoken无效");

                        }catch (JWTDecodeException e){
                            logger.info("\ntoken获取异常{}",e);
                            e.fillInStackTrace();
                        }
                    }

                }
            }

            request.setAttribute("message","请登录后查看");
//            request.getRequestDispatcher("/WEB-INF/jsp/body/login.jsp").forward(request,response);
            request.getRequestDispatcher("login").forward(request,response);

            return false;
        }

        logger.info("\n拦截器放行\n");
        return true;
    }


//    postHandle在业务处理请求执行完成之后，视图被调用之前执行,只有pre方法返回true的时候才会被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        modelAndView.setViewName("login");
        logger.info("\n拦截器放行,执行postHandle方法（在controller执行完后，返回视图前执行）\n");
        super.postHandle(request, response, handler, modelAndView);
    }

//    afterCompletion在完全处理完请求后(也就是controller执行后)被调用 用来处理清理资源或者后续关闭等行为
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.info("\n拦截器afterCompletion方法 [Controller postHandle方法] 执行后执行\n");
        super.afterCompletion(request, response, handler, ex);
    }
}
