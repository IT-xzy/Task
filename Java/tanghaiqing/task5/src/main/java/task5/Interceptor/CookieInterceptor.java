package task5.Interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import task5.util.TokenUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * 在preHandle方法里面，进行业务逻辑编写。
 * 主要是对是否是同一个token进行判断，并且判断它是否在token的有效值内。
 */
public class CookieInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger(CookieInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入cookie拦截器：preHandle()");
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            logger.info("没有登录!");
            //重定向到登录页面
            response.sendRedirect("logging");
            return false;
        }
        for (Cookie c : cookies) {
            logger.info("--------------------------------------");
            //判断cookie是否等于存入时的token的名字
            if (c.getName().equals("token")) {
                logger.info("开始判断token的正确性和有效值");
                //判断cookie里面的token是否跟session里面一样
                if (c.getValue().equals(request.getSession().getAttribute("token"))) {
                    //先进行cookie的解密
                    String token = c.getValue();
                    String str = TokenUtils.decryptToken(token);
                    logger.info("解密token后：" + str);
                    String loginTime = str.substring(str.indexOf("|")+1);
                    logger.info(loginTime);
                    //判断token的有效值
                    if ((System.currentTimeMillis() - Long.valueOf(loginTime)) < 5 * 60 * 1000) {
                        logger.info("token在有效范围类！");
                        return true;
                    }else {
                        logger.info("token有效时间已过");
                        response.sendRedirect("../logging");
                        return false;
                    }
                }else {
                    logger.info("token不一致");
                    response.sendRedirect("../logging");
                    return false;
                }
            }
        }
        logger.info("tonken验证失败");
        response.sendRedirect("../logging");
        return false;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
