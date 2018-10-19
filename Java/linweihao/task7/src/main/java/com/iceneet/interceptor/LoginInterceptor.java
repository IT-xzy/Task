package com.iceneet.interceptor;

import com.iceneet.untils.CookiesUntil;
import com.iceneet.untils.DESUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = CookiesUntil.getUid(httpServletRequest,"token");
        if (token!=null){
            String detoken = DESUtil.decode(token);
            String oldtimestamp = detoken.split("\\$")[0];
            long nowtimestamp = System.currentTimeMillis();
            long diffTime = nowtimestamp-Long.parseLong(oldtimestamp);
            if(diffTime/(60*60*1000*24)>8){
                httpServletResponse.sendRedirect("/test");
                return false;
            }else {
                return true;
            }
        }else {
            httpServletResponse.sendRedirect("/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
