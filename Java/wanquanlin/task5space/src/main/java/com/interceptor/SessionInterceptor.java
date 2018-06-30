package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jaime
 * @Date: 2018/4/12 22:12
 * @Description: *
 */
public class SessionInterceptor  implements HandlerInterceptor {
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handel) throws Exception {
        HttpSession session = req.getSession();
        // 从session当中获取特定的数据
        Object sessiontoken=session.getAttribute("token");
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = req.getCookies();
        //判断请求中的cookies非空
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        //判断时候含有对应的cookie
          if (cookieMap.containsKey("token")) {
            Cookie cookie2 = (Cookie) cookieMap.get("token");
            //已登录
            if(cookie2.getValue().equals(sessiontoken)) {

                System.out.println(cookie2.getValue()+"二哈");
                return true;
            }
            //未登录
            else {
                res.sendRedirect(req.getContextPath()+"/login");
                return false;
            }
            }
          //判断请求中的cookies没有对应的cookie
          else {
              res.sendRedirect(req.getContextPath()+"/login");
              return false;
          }
        }
        else {
            res.sendRedirect(req.getContextPath()+"/login");
            return false; }
        }
        }






