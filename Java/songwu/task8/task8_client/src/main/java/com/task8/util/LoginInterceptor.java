package com.task8.util;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Create by SongWu on 2018/7/2
 */
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(LoginInterceptor.class);

    public LoginInterceptor() {
        super();
    }

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     *
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

//普通cookie验证
      /*  Cookie cookie = CookieUtil.getCookieByName(request, "token");
        if (cookie.getValue() != null) {

            byte[] result = DESUtil.decrypt(Base64.decodeBase64(cookie.getValue()), DESUtil.getValue("keys"));
            String u = new String(result);

            String[] value = u.split("-");
            long v1 = Long.parseLong(value[1]);
            System.out.println("cookie存在");
            if (System.currentTimeMillis() - v1 <  5*60*1000) {
                System.out.println("cookie有效");
                return true;
            }

        }

        System.out.println("没有登录，或cookie已经失效");
        response.sendRedirect("/logout");
        return false;
   */


//    基于cookie,session的验证
        if (CookieUtil.getCookieByName(request, "tokens") != null) {
            Cookie cookie = CookieUtil.getCookieByName(request, "tokens");
            if (cookie.getValue() != null) {
                logger.info("cookie中token的值" + cookie.getValue());
                String token = (String) request.getSession().getAttribute("tokens");
                logger.info("session中token的值：" + token);
                if (JwtUtil2.parseWebToken(cookie.getValue()) != null) {
                    if (cookie.getValue().equals(token)) {
                        logger.info("token有效");
                        return true;
                    }
                }
            }
        }
        logger.info("token失效");
//        通过response页面重定向
        //        response.sendRedirect("/logout");
//        request转向页面
        request.getRequestDispatcher("/logout").forward(request, response);

        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

