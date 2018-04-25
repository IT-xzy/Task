package com.fml.interceptor;

import com.fml.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getServletPath().endsWith("vocation")){
            LOGGER.info("请求已进入拦截器！");

            Cookie cookies = CookieUtil.getCookieByName(request,"tokens");
            if (cookies == null){
                LOGGER.info("用户还未登录或cookie已经失效，需要重新登录！");
                response.sendRedirect(request.getContextPath() + "/viewLogin");
                //request.getRequestDispatcher(request.getContextPath() + "/viewLogin").forward(request,response);
                return false;
            }
            //若cookie存在，直接登录
            /*String tokens = cookies.getValue();
            System.out.println(tokens);*/
            LOGGER.info("token有效，用户免登录！");
            return true;


           /* 用普通cookie做判断
            Cookie cookie = CookieUtil.getCookieByName(request,"token");
            if (cookie == null){
                LOGGER.info("用户还未登录或cookie已经失效，需要重新登录！");
                response.sendRedirect(request.getContextPath() + "/viewLogin");
                return false;
            }
            String token = cookie.getValue();
            System.out.println(token);
            LOGGER.info("token有效，用户免登录！");
            return true;
            */


        }
        return true;

        /*//逻辑错误，能传token这个cookie过来，cookie就没有失效就不用判断时间。我们vocation里面并不需要用户信息，所以没有必要解析cookie
            Cookie cookie = CookieUtil.getCookieByName(request,"token");
            if (cookie == null){
                LOGGER.info("用户还未登录或cookie已经失效，需要重新登录！");
                response.sendRedirect(request.getContextPath() + "/viewLogin");
                return false;
            }
            String token = cookie.getValue();
            //对token进行解密
            String[] result = DESUtil.decrypt(token,DESUtil.getkey()).trim().split(":");
            //判断cooke是否有效
            if (System.currentTimeMillis() - Long.parseLong(result[1]) <= 30*60*1000){
                LOGGER.info("cookie有效，免登录！");
                return true;
            }else {
                LOGGER.info("cookie已经失效，需要重新登录！");
                request.getRequestDispatcher(request.getContextPath() + "/viewLogin").forward(request,response);
                //response.sendRedirect("/././viewLogin");
                return false;
            }*/



        //最原始的版本
        //为什么startWith不可以？
        /*ArrayList<String> list = new ArrayList<>();
        if (request.getServletPath().endsWith("vocation")){
            //System.out.println(request.getServletPath());
            Cookie[] cookies = request.getCookies();
            if (cookies == null){
                LOGGER.error("something error,cookies is null !");
                response.sendRedirect("/viewLogin");
                return false;
            }
            //System.out.println(cookies);
            for (Cookie cookie : cookies){
                list.add(cookie.getName());
            }
            for (String s : list){
                System.out.println(s);
            }

            if (list.contains("token")){
                for (Cookie cookie : cookies){
                    while (cookie.getName().equals("token")){
                        String token = cookie.getValue();
                        System.out.println(token);
                        //对token进行解密
                        String[] result = DESUtil.decrypt(token,DESUtil.getkey()).trim().split(":");
                        for (String s: result){
                            System.out.println(s);
                        }
                        //判断cooke是否有效
                        if (System.currentTimeMillis() - Long.parseLong(result[1]) <= 30*60*1000){
                            LOGGER.info("cookie有效，免登录！");
                            return true;
                        }else {
                            LOGGER.info("cookie已经失效，需要重新登录！");
                            response.sendRedirect("viewLogin");
                            return false;
                        }
                    }
                }

            }else {
                LOGGER.info("用户没有登录！");
                response.sendRedirect("viewLogin");//跳转的时候为什么会输出viewLogin
                return false;
            }
        }*/




    }
}
