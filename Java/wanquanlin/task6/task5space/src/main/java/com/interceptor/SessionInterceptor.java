package com.interceptor;

import com.cache.RedisCacheUtil;
import com.util.JwtUtil;
import com.service.LoginServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jaime
 * @Date: 2018/4/12 22:12
 * @Description: **/


public class SessionInterceptor  implements HandlerInterceptor {
    @Autowired
    LoginServiceImpl loginService;
    @Autowired
    RedisCacheUtil redisCacheUtil;
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handel) throws Exception {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = req.getCookies();
        //判断请求中的cookies非空
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        //判断时候含有对应的cookie
          if (cookieMap.containsKey("token")) {
            Cookie cookie2 = (Cookie) cookieMap.get("token");
            try {
                Claims c= JwtUtil.parseJWT(cookie2.getValue());
                String s=c.getSubject();
                Long s2= Long.valueOf(s);
                Long idInRedis= (Long) redisCacheUtil.hget("signIn",cookie2.getValue());
                //数据对比
                if(s2.equals(idInRedis)) {
                    return true;
                }
                //未登录
                else {
                    res.sendRedirect(req.getContextPath()+"/login");
                    return false;
                }
            }
            catch (ExpiredJwtException e){
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






