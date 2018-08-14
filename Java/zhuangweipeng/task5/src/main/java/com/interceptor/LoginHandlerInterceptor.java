package com.interceptor;

import com.utils.DesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    private static final Log log = LogFactory.getLog(LoginHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("---login拦截器preHandler方法执行---");
        DesUtil desUtil = new DesUtil("Hello");
        //从cookie中取出token
        log.info("---准备进入遍历Cookie---");
        Cookie[] cookies = request.getCookies();
        //遍历cookie
        if (cookies == null) {
            request.getRequestDispatcher("/login/reLogin.jsp").forward(request, response);
            log.info("重定向到重新登陆界面1");
            return false;

        }
        log.info("---进入Cookies遍历---");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginToken")) {
                String encryptLoginToken = cookie.getValue();
                log.info("加密的cookieToken：" + encryptLoginToken);
                //验证token的有效性
                //System.out.println("加密的cookieToken：" + encryptLoginToken);
                String decryptLoginToken = desUtil.decrypt(encryptLoginToken);
                String[] split = decryptLoginToken.split("\\.");
                long loginTime = Long.parseLong(split[1]);
                Long currentTime = System.currentTimeMillis();
                if (0 > currentTime - loginTime || currentTime - loginTime > 30 * 60 * 1000) {
                    //当为true时，跳转到请求重新登录页面
                    //response.sendRedirect(request.getContextPath() + "/login/reLogin.jsp");
                    request.getRequestDispatcher("/login/reLogin.jsp").forward(request, response);
                    return false;
                }
                //输出加密值
                log.info("decryptLoginToken:  " + decryptLoginToken);
                //或者session值
                log.info("getSession   " + request.getSession().getAttribute("loginSession"));
                if (decryptLoginToken.equals(request.getSession().getAttribute("loginSession"))) {
                    //当为true时，放行
                    log.info("---验证通过---");
                    return true;
                }
                log.info("第二层判断");
            }
            log.info("第三层判断");
        }
        ////如果没有登录,重定向到请求重新登录页面
        request.getRequestDispatcher("/login/reLogin.jsp").forward(request, response);
        log.info("重定向到重新登陆界面2");
        return false;
    }

    // 在业务处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    // 在DispatcherServlet完全处理完请求之后被调用，用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}

