package com.interceptor;

import com.entity.User;
import com.service.UserService;
import com.util.CookieUtil;
import com.util.DESUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @className: UserInterceptor
 * @description: 拦截器
 * @author: ytd
 * @create: 2018-09-03 11:42
 **/
@Component
/*component标注spring框架配件*/
public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(UserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null != user) {
            logger.info("会话存在,可继续访问");
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/jnshu/login");
        return false;

/*        boolean flag = false;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null != user) {
            logger.info("会话存在,可继续访问");
            return true;
        }else {
            logger.info("属于新会话,验证cookie");
            Cookie cookie = CookieUtil.getCookie(request,user.getName());
            if (null != cookie){
                logger.info("cookie存在");
                String tokenDES = CookieUtil.getCookieValue(request,user.getName());//这是被DES加密的值
                String token = DESUtil.decode("ytd1129097428",tokenDES);//解密得到明文值
                logger.info("通过cookieValue得到用户名");
                String[] tokens = token.split(":");
                String nameFromToken = tokens[0];
                //从数据库中通过用户名查找信息
                User user1 = userService.findByName(nameFromToken);
                logger.info("验证是否有记录");
                if (null != user1){
                    logger.info("有记录");
                    return true;
                }else {
                    return false;
                }
            }
        }
        response.sendRedirect(request.getContextPath()+"/jnshu/login");
        return flag;*/
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
