package com.zyq.interceptor;

import com.zyq.service.UserService;
import com.zyq.util.DESUtil;
import com.zyq.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    String idPWD = JwtToken.unsign(token,String.class);
                    Integer id = Integer.valueOf(DESUtil.decode(idPWD));
                    Integer userId = userService.selectIdById(id);
                    if (userId!=null && id==userId){
                        return true;
                    }
                }
            }
        }
        request.setAttribute("studentMsg","登录后才能查看此页面，请登录！");
        request.setAttribute("item","loginBody");
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
