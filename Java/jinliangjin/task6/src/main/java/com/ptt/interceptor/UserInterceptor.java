package com.ptt.interceptor;

import com.ptt.pojo.User;
import com.ptt.util.CookieUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: UserInterceptor
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 19:50
 * @Version: 1.0
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter{
    @Value("${cookieName}")
    private String cookieName;
    @Value("${salt}")
    private String salt;
    private Logger logger = Logger.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //如果会话未关闭
        if(null != user){
            logger.info("会话未关闭，可以继续访问");
            flag = true;
            return flag;
        } else {//是新的会话
            logger.info("是新会话，正在验证cookie...");
            Cookie cookie = CookieUtil.getCookieByName(request, cookieName);
            if(null != cookie) {//cookie存在
                logger.info("cookie存在");
                flag = true;
                return flag;
            }
            logger.info("是新session且没有cookie");
            session.setAttribute("message", "cookie已过期或已被删除，请重新登录");
            response.sendRedirect(request.getContextPath() + "/it/login");
            return flag;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
