package org.wyq.task.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.wyq.task.token.JwtToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfessionInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                String token = c.getValue();
                if(JwtToken.verifyToken(token)){
                    return true;
                }
            }
        }
//        httpServletRequest.getRequestDispatcher("/school/sign_in").forward(httpServletRequest, httpServletResponse);
        httpServletResponse.sendRedirect("/school/sign_in");
        return false;
    }
}
