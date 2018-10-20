package com.task5.interceptor;

import com.task5.until.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    JWT jwtUtil;

    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String requestUri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        String url = requestUri.substring(contextPath.length());
        String token = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }
        Map<String, Object> map = jwtUtil.parseToken(token);
        String username = (String) map.get("username");
        String message = (String) map.get("ERR_MSG");
        if (message != null) {
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login").forward(request, response);
        }
        if (username == null) {
            // 跳转到登录页面
            request.setAttribute("message", "您还没用登录，请登录：");
            request.getRequestDispatcher("/login").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
            else {
            return true;
        }
    }

    // 在业务处理器处理请求完成之后，生成视图之前执行
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle...");
//        if(modelAndView != null){
//            Map<String, String> map = new HashMap<String, String>();
//            modelAndView.addAllObjects(map);
//        }
//    }

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion...");
//    }
}
