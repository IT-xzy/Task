package com.token.interceptor;

import com.token.service.UserInfoService;
import com.token.utils.DesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        logger.info("URL is {}",url);

        if(url.indexOf("login")>=0){
            logger.info(""+url.indexOf("login"));
            return true;
        }

        Cookie[] cookies = request.getCookies();
        for(Cookie c :cookies ){
            logger.info("cookie_name={},cookie_value={}",c.getName(),c.getValue());

            if (c.getName().equals("token")) {
                String decrypted = DesUtil.decrypt(c.getValue());
                String[] strKey=decrypted.split("\\.");
                long expired_time = System.currentTimeMillis() - Long.parseLong(strKey[1]);
                logger.info("time=={}",expired_time);
                if (userInfoService.getByName(strKey[0]) != null && expired_time < 1000*60*30) {
                    return true;
                }
            }
        }

        //不符合条件的，跳转到登录界面
        /*请求转发request.getRequestDispatcher()
        forward() 用来传递request的，可以一个Servlet接收request请求，
         * 另一个Servlet用这个request请求来产生response。*/
        request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
