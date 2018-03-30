package lujing.controller.interceptor;

import lujing.Constant;
import lujing.security.JwtUtils;
import lujing.serviceimpl.UserServiceImpl;
import lujing.util.CookieUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author lujing
 * Create_at 2018/1/4 19:46
 */
public class LoginInterceptor implements HandlerInterceptor {
    public static Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    UserServiceImpl userServiceImpl;
    
    /**
     * 拦截需要登录的页面，判断cookie中的用户名是否在数据库中。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String url = request.getRequestURI();
        String contextpath = request.getContextPath();
        
        logger.info("这是请求的url：" + url+"..."+contextpath);
        
      String subject =  JwtUtils.getSubject(request,Constant.jwtCookieName,Constant.siginKey);
      if(null == subject){
          response.sendRedirect(request.getContextPath()+"/loginjsp");
          return false;
      }
      String namess =   userServiceImpl.findUserByName(subject);
      if(null == namess){
          response.sendRedirect(request.getContextPath()+"/loginjsp");
          return false;
      }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    
    }
    
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    
    }
}
