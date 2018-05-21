package cn.summerwaves.interceptor;

import cn.summerwaves.util.CookieUtil;
import cn.summerwaves.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie cookie = CookieUtil.getCookieByName(httpServletRequest, "token");
        //找不到token或token验证失败
        if (cookie == null || !TokenUtil.checkToken(cookie.getValue())) {
            httpServletRequest.getRequestDispatcher("/skip").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        Cookie cookie = CookieUtil.getCookieByName(httpServletRequest, "token");
        modelAndView.addObject("username", TokenUtil.getUsernameInToken(cookie.getValue()));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
