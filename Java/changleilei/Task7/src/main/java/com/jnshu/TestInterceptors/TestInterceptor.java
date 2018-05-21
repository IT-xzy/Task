package com.jnshu.TestInterceptors;
import com.jnshu.utils.EncryUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {
    private Cookie cookie;
    public String defultLogin = "/";//默认登录页面
    //public Map<String,String> defineUrls;//自定义的Url，自定义拦截后的处理页面。

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cook : cookies) {
                if (cook.getName().equals("name")) {
                    cookie = cook;
                    String check = EncryUtil.decrypt(cookie.getValue());
                    String[] strings = check.split(",");
                    Long df = Long.valueOf(strings[1]);//从cookie中获取设置的时间
                    Long df2 = System.currentTimeMillis();//设置日期格式
                    if ((df2 - df) > 60 * 1000 || (df2 - df) < 0) {
                    } else {
                        return true;
                    }
                }
                cookie = null;
            }
        }
        response.sendRedirect(request.getContextPath() + defultLogin);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (cookie == null) {
            response.sendRedirect(request.getContextPath() + defultLogin);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
