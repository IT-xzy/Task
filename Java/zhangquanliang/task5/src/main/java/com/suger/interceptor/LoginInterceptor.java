package com.suger.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.suger.pojo.User;
import com.suger.service.UserService;
import com.suger.util.DesUtils;
import com.suger.util.JwtUtils;
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


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求的RUi:去除http:localhost:8080这部分之后的部分
        String url = request.getRequestURI();

        // 非登录状态，不能参看学员信息
        if (!url.contains("/u/student")) {
            return true;
        }



        // 获取 cookie
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            // 遍历cookie如果找到登录状态则返回true执行原来controller的方法
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    JwtUtils jwtUtils = new JwtUtils();
                    // 解密token
                    DecodedJWT jwt = jwtUtils.decodedToken(token);

                    // 获取当前系统时间戳
                    long date = System.currentTimeMillis();

                    String name = jwt.getClaim("username").asString();

                    logger.info("加密后的用户名：" + name);
                    // 解密 用户名
                    name = DesUtils.decode(name);
                    logger.info("解密后的用户名：" + name);
                    User user = userService.getUserByName(name);


                    // token 是否过期，签发者 是否为jnshu, 用户名 是否为空，用户名 是否一致
                    if (date < jwt.getExpiresAt().getTime() && "jnshu".equals(jwt.getIssuer()) && user != null && user.getName().equals(name)) {
                        logger.info("\n");
                        logger.info("token有效");

                        // 60分钟后token过期
                        long maxAge = 60L * 60L * 1000L;

                        String newToken = jwtUtils.getToken(jwt.getClaim("username").asString(), maxAge);
                        cookie.setValue(newToken);
                        cookie.setPath("/");
                        // 1天过期
                        cookie.setMaxAge(24*60*60);
                        response.addCookie(cookie);
                        HttpSession session = request.getSession();
                        session.setAttribute("username", name);
                        return true;
                    } else {
                        logger.info("\n");
                        logger.info("token无效");
                        request.setAttribute("msg", "登录验证过期，请重新登录！");

                        //cookie.setValue("");
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        HttpSession session = request.getSession();
                        session.invalidate();

                        request.getRequestDispatcher("/u/login").forward(request, response);
                        return false;
                    }
                }
            }
        }
        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");

        request.getRequestDispatcher("/u/login").forward(request, response);
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}