package Task4.interceptor;

import Task4.service.UserService;
import Task4.unit.CookieUnit;
import Task4.unit.TokenJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    @Qualifier("rmiUserA")
    UserService userService;
    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        LOGGER.info("进入拦截器");




        //此方法测试字符串是否以指定的后缀 suffix 结束。.endsWith()
        if (request.getServletPath().endsWith("position")|request.getServletPath().endsWith("user")) {
            LOGGER.info("拦截成功！");
            Cookie cookie = CookieUnit.getCookieByName(request, "token");
            Map<String, Object> map = TokenJWT.validToken(cookie.getValue());
            String state = (String) map.get("state");



            if (cookie == null) {
                LOGGER.info("用户还未登录");
//                throw new MyException("请登入");
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
            if (state.equals("EXPIRED")) {
                LOGGER.info("过期");
//                throw new MyException("已过期,请登入");
                response.sendRedirect(request.getContextPath()+"/");
                return false;
            }


            LOGGER.info("cookie有效，用户免登录！");
            return true;
            }
//            if (request.getServletPath().endsWith("email")){
//                if (user.getEmail()!=null) {
//                    LOGGER.info("邮箱已绑定");
//                    response.sendRedirect(request.getContextPath() + "/");
//                    return false;
//                }
//                return true;
//                }
//        if (request.getServletPath().endsWith("phone")){
//            if (user.getPhone()!=null) {
//                LOGGER.info("手机已绑定");
//                response.sendRedirect(request.getContextPath() + "/");
//                return false;
//            }
//            return true;
//        }
        return true;
    }
    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}