package com.interceptor;

import com.tools.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

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
        if (token != null) {
            // 解析token
            try {
                //获取token里面的用户名
                Claims claims = jwtUtil.parseToken(token);
                String username = claims.getSubject();
                if (username == null || username.isEmpty()) {
                    request.setAttribute("message", "本次登录已注销");
                    request.getRequestDispatcher("/login").forward(request, response);
                }
                //从redis里面获取该用户对应的token
                String token2 = redisTemplate.opsForValue().get(username + "token");
                //分别获取2个token的生成时间
                Date generateTime1 = claims.getIssuedAt();
                Date generateTime2 = jwtUtil.parseToken(token2).getIssuedAt();
                //账号在别处登录
                if (generateTime1.before(generateTime2)) {
                    request.setAttribute("message", "账号已在别处登录");
                    request.getRequestDispatcher("/login").forward(request, response);
                }
                if (generateTime1.after(generateTime2)) {
                    request.setAttribute("message", "请勿伪造登录信息");
                    request.getRequestDispatcher("/login").forward(request, response);
                }
                return true;
            } catch (SignatureException | MalformedJwtException e) {
                // TODO: handle exception
                // don't trust the JWT!
                // jwt 解析错误
                request.setAttribute("message", "系统错误，请尝试重新登录：");
                request.getRequestDispatcher("/login").forward(request, response);
            } catch (ExpiredJwtException e) {
                // TODO: handle exception
                // jwt 已经过期，在设置jwt的时候如果设置了过期时间，这里会自动判断jwt是否已经过期，如果过期则会抛出这个异常，我们可以抓住这个异常并作相关处理。
                request.setAttribute("message", "登录信息已过期，请重新登录：");
                request.getRequestDispatcher("/login").forward(request, response);
            }
        } else {
            request.setAttribute("message", "您还没有登录，请登录：");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        return false;
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
