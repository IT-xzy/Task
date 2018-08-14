package com.interceptor;

import com.tools.JwtUtil;
import com.tools.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisUtil redisUtil;

    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("preHandle...");
//        String requestUri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        String url = requestUri.substring(contextPath.length());
//        System.out.println("requestUri:" + requestUri);
//        System.out.println("contextPath:" + contextPath);
//        System.out.println("url:" + url);
        String token = null;
        //从cookie里取出token
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }
        if (token == null) {
            request.setAttribute("message", "您还没有登录");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        //从session里面获取用户名
        String name = (String) request.getSession().getAttribute("username");
        //从redis获取该用户的token
        String token2 = redisUtil.getString(name + "token");
        if (token2 == null) {
            request.setAttribute("message", "您还没有登录或者本次登录已注销");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        if (token.equals(token2)) {
            Map<String, Object> map = jwtUtil.parseToken(token);
            String message = (String) map.get("ERR_MSG");
            if (message != null) {
                request.setAttribute("message", message);
                request.getRequestDispatcher("/login").forward(request, response);
                return false;
            } else {
                return true;
            }
        } else {
            request.setAttribute("message", "账号已在别处登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }

    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle...");
//        if(modelAndView != null){
//            Map<String, String> map = new HashMap<String, String>();
//            modelAndView.addAllObjects(map);
//        }
    }

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion...");
    }
}
