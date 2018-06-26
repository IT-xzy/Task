package com.ptt.interceptor;

import com.ptt.pojo.Student;
import com.ptt.util.CookieUtil;
import com.ptt.util.DESUtil;
import com.ptt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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

public class StudentInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisUtil redis;
    @Value("${cookieName}")
    private String cookieName;
    private Logger logger = LoggerFactory.getLogger(StudentInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        //如果会话未关闭
        if (null != student) {
            request.setAttribute("url", student.getProfilePhoto());
            logger.info("会话未关闭，可以继续访问");
            flag = true;
            return flag;
        } else {//是新的会话
            logger.info("是新会话，正在验证cookie...");
            logger.info("cookieName：" + cookieName);
            String cookieValue = CookieUtil.getCookieValue(request, cookieName);
            if(cookieValue != null){
                String name = DESUtil.decrypt(cookieValue).split("-")[0];
                logger.info("cookieValue：" + cookieValue);
                String cookieValueCache = (String) redis.getValue(cookieName, name);
                logger.info("cookieValueCache：" + cookieValueCache);
                if (cookieValueCache != null && cookieValue.equals(cookieValueCache)) {
                    flag = true;
                    return flag;
                }
            }
            logger.info("是新session且没有cookie");
            request.setAttribute("message", "cookie已过期");
            request.getRequestDispatcher("/it/login").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/it/login");
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
