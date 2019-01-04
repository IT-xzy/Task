package com.tiles.interceptor;

import com.tiles.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author suger
 * @date 2018/11/20 23:46
 */
@Controller
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    UserService userService;

     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

         //获取请求的RUi:去除http:localhost:8080这部分之后的部分
         String url = request.getRequestURI();

         //url :除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
       /*  if (url.indexOf("/u/login") >= 0) {
             return true;
         }*/

         if(!url.contains("/u/user")) {
             return true;
         }

         //获取session 中的登录状态
         HttpSession session = request.getSession();
         String username = (String) session.getAttribute("USER_SESSION");

         // 获取 cookie
         Cookie[] cookies =request.getCookies();
         if(null != cookies){
             // 遍历cookie如果找到登录状态则返回true执行原来controller的方法
             for(Cookie cookie:cookies){
                 if(cookie.getName().equals("isLogin")&&cookie.getValue()!= null){
                     return true;
                 }
             }
         }

         //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (username != null) {
                 return true;
        }
        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");

        request.getRequestDispatcher("/u/login").forward(request, response);
         //response.sendRedirect(request.getContextPath()+"/u/login");
        return false;
     }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }
}
