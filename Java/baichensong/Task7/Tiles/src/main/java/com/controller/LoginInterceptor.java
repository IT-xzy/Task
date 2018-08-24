package com.controller;


import com.DES.CookieUtil;
import com.DES.DESUtil;
import com.DES.TokenUtil;
import com.model.Login;
import com.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    public StudentService service;

    private static Log log = LogFactory.getLog(LoginInterceptor.class);
    //不拦截的页面
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String[] strings = new String[]{"homeTwo", "login", "doLogin","exit","z"};
        String uri = request.getRequestURI();
        for (String s : strings) {
            if (uri.indexOf(s) != -1) {
                log.info("拦截成功");
                return true;
            }
        }
        //按照cookie的name来  找到 对应的cookie
        Cookie cookie = CookieUtil.getCookieByName(request, "token");
        if (cookie != null) {
            // 获取cookie的value 并转为String
            String token = cookie.getValue();
            log.info(token);
            // jwt token 解密
            String[] st = TokenUtil.tool(token);
            //DES解密
                String[] sr= DESUtil.tool2(st);
            if (sr[0] != null && sr[1] != null) {
                log.info("解密后：" + sr[0] + sr[1]);
                Login login = service.login(sr[0]);//采用 用户名 查询------------------------------------------待修改
                String s = login.getUsername();
                String t = String.valueOf(login.getLandtime()); //Long 转为String
                log.info("数据库的值"+s);
                //最后判断  验证 输入用户名 是否与cookie 相等
                if (sr[0].equals(s) && (sr[1].equals(t))) {
                    log.info("cookie判断成功");
                    return true;
                } else {
                    httpServletResponse.sendRedirect(request.getContextPath() + "/login");
                    log.info("判断失败");
                    return false;
                }
            }
             return false;
        } else {
            log.info("用户还未登陆");
            httpServletResponse.sendRedirect(request.getContextPath() + "/login");
            return false;
        }


    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}