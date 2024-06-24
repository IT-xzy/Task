package com.jnshu.Interceptor;

import com.jnshu.DESUtil;
import com.jnshu.Jwt;
import com.jnshu.controller.BannerController;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Length;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    private static final org.apache.log4j.Logger logger = Logger.getLogger(LoginInterceptor.class);

    //=================================================================================
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        从请求中取出cookie信息
        Cookie[] cookies = httpServletRequest.getCookies();
//                判断cookies的长度为0的话，就是没有cookies，返回登录界面，让用户登录，发给用户一个cookies

        if (cookies == null && cookies.length == 0) {
            logger.info("用户没有cookies========" + cookies);
            String token = httpServletRequest.getHeader("token");

            String tokenming = DESUtil.decrypt(token);
            logger.info("token明文" + tokenming);
//                    将明文放进数组中

            String[] strs = tokenming.split("\\|");
            String timeStamp = strs[0];
            logger.info("当时的加密后时间" + timeStamp);
//                    对时间进行解密
            Long time = DESUtil.decryptToLong(timeStamp);
            logger.info("当时的时间" + time);
//                    判断cookies时间是否过期

            if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
                System.out.println("token过期=====");
                //返回登录页面
                httpServletResponse.sendRedirect("/a/login");

            } else {
                String namestr = strs[2];
                logger.info("用户名为" + namestr);
                String idstr = strs[0];
                Long id = DESUtil.decryptToLong(idstr);
                User userid = userService.selectById(id);
                logger.info("查出来的userid" + userid);
                if (userid == null) {
                    logger.info("没有该用户");
                } else {
                    return true;
                }
            }

        } else {
//            用户有cookies
            logger.info("用户cookies的数量========" + cookies.length);
//            ===================================================================================
//            遍历一下cookies，如果请求的cookies与办法的cookies相同，那么这位用户就可以通过
//            for (Cookie cookie : cookies) {
////                先判断用户名字是否相同
//                if (cookie.getName().equals("name")) {
//                    logger.info("cookies名字为" + cookie.getValue());
//
//                    if (cookie.getName().equals("token")) {
//                        logger.info("token is " + cookie.getValue());
//                    }
//
//                    return true;
//                }
//
//            }
//            =======================================================================================
            for (int i = 0; i < cookies.length; i++) {
                logger.info("cookies的名字有" + cookies[i].getName());
//                判断cookies中有没有name为token的值
                if (cookies[i].getName().equals("token")) {
//                    取出它的键值对
                    String token = cookies[i].getValue();

//                    ===========================================
//                    if (Jwt.parseJWT(token) != null)
//
//                        logger.info("验证成功");
//                    return true;
//                    将token解密
//                    ==================================================
                    String tokenming = DESUtil.decrypt(token);
                    logger.info("token明文" + tokenming);
//                    将明文放进数组中

                    String[] strs = tokenming.split("\\|");
                    String timeStamp = strs[0];
                    logger.info("当时的加密后时间" + timeStamp);
//                    对时间进行解密
                    Long time = DESUtil.decryptToLong(timeStamp);
                    logger.info("当时的时间" + time);
//                    判断cookies时间是否过期

                    if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
                        System.out.println("token过期=====");
                        //返回登录页面


                    } else {
                        String namestr = strs[1];
                        logger.info("用户名为" + namestr);
                        List<User> user = userService.selectByName("namestr");
                        logger.info("查出来的user" + user);
                        if (user == null) {
                            logger.info("没有该用户");
                        } else {
                            return true;

                        }
                    }
                }

            }
        }

//        给颁发一个cookie
        httpServletResponse.sendRedirect("/login");
        return false;
    }


    //    在业务处理器处理请求完成之后,生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //    在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
