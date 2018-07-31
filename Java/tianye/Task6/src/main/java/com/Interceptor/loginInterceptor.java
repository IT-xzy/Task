package com.Interceptor;



import com.Cookie.cookieTool;
import com.pojo.t_information;
import com.service.stuService;
import com.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class loginInterceptor implements HandlerInterceptor {
    @Autowired
    stuService stuService;
    private static Logger logger= Logger.getLogger(loginInterceptor.class );
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception {
        boolean beFilter = true;
        String requestURL = request.getRequestURI();
        String[] noFilter = new String[]{"login", "introduction", "register","kfc","findByKey"};
        //没有拦截器的情况
        for (String s : noFilter) {
            if (requestURL.indexOf(s) > 0) {
                logger.info("进入到拦截方法");
                return true;
            }
        }
        //有拦截器的情况
        logger.info(beFilter + "lijie");
        if (beFilter = true) {
            logger.info("进入方法");
            String path = request.getContextPath(); //返回当前页面所在应用的名字
            Cookie token = cookieTool.getCookieName(request, "token");
            logger.info("cookie中的" + token);
            if (token != null) {
                logger.info(token.getValue() + "有用户");
                String tokenData = token.getValue();
                String decryptToken = Token.decryptToken(tokenData);
                String[] strings = decryptToken.split("/");
                String userId = strings[0];
                logger.info("账号名为：" + userId);
                t_information t_information = stuService.select(userId);
                if (t_information == null) {
                    cookieTool.addCookie(response, "token", null, 0);
                    try {
                        response.sendRedirect("localhost:8080/login");
                        return false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    request.getSession().setAttribute("error", "请先登录");
                } else {
                    logger.info("存在此用户");
                    return true;
                }
            } else {
                logger.info("token为空");

                request.getRequestDispatcher("WEB-INF/tiles/login.jsp").forward(request, response);
                return false;
            }

        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
       // TODO Auto-generated method stub

    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }


}
