package interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import service.UserService;
import util.CookieUtil;
import util.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录拦截器，拦截登录请求
 * Interceptor中的preHandle方法都会在Controller方法调用之前调用。
 * SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返回值为false
 *当preHandle的返回值为false的时候整个请求就结束了
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger log = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        Map<String,Object> payload;
        String token;
        Cookie[] cookies = request.getCookies();
        if (null != cookies){
            for (Cookie cookie:cookies){
                if ("token".equals(cookie.getName())){
                   token = CookieUtil.getValue(request,"token");
                   payload = new JwtUtil().verifyJwt(token);
                   long exp = (long) payload.get("exp");
                   long nowMillis = System.currentTimeMillis();
                    //验证信息，登录时间小于30min，无需再登录
                   if(exp-nowMillis>30*60*1000 )
                        log.info("LoginInter: cookie登录信息未失效");
                        return true;
                    }
            }
       }
            //没有找到登录状态则重定向到登录页，返回false，不执行原来controller的方法
            log.info("LoginInter: 登录信息已失效，重定向到登录页");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
    }
}

