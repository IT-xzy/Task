package jnshu.tool;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器，必须实现HandlerInterceptor接口(拦截器)
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger (LoginInterceptor.class);//引入日志配置

    //    preHandle方法，顾名思义，该方法将在请求处理之前进行调用。该方法的返回值是布尔值Boolean 类型的，
// 当它返回为false 时，表示请求结束，后续的Interceptor 和Controller都不会再执行；
// 当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，
// 如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info ("进入preHandle拦截器");
        Cookie[] cookies = httpServletRequest.getCookies ();
        String token = null;
//    取出token
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName ().equals ("token")) {
                    token = cookie.getValue ();
                }
            }
        }


        logger.info ("取出的token是：" + token);
//        String etoken = (String) httpServletRequest.getSession ().getAttribute ("sessionToken");
        long time = 24 * 60 * 60 * 1000;//过期时间一天，单位毫秒
//    验证token
        try {
            Boolean rb = TokenUtil.check (token, time);
            logger.info ("是否验证成功：" + rb);
            if (rb) {
                return true;
            }
        } catch ( Exception e ) {
            httpServletResponse.sendRedirect ("/toLogin");
            return false;
        }


        httpServletResponse.sendRedirect ("/toLogin");
//        response.sendRedirect("/toLogin");
        return false;
    }

    //    postHandle方法只能是在当前所属的Interceptor 的preHandle 方法的返回值为true 时才能被调用。
//    postHandle方法，在Controller 方法调用之后执行，
// 但是它会在DispatcherServlet 进行视图返回渲染之前被调用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
// postHandle 方法被调用的方向跟preHandle 是相反的，也就是说先声明的Interceptor 的postHandle 方法反而会后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //    afterCompletion方法，该方法也是需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行。
// 顾名思义，该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
//    这个方法的主要作用是用于进行资源清理工作的。
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
