package hzw.interceptor;

import hzw.service.StudentService;
import hzw.util.DESUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 登陆拦截器
 **/
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，
     * 可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 判断session
        Cookie[] cookies = httpServletRequest.getCookies();
        logger.info("Cookie长度为: " + cookies.length);
        logger.info("拦截器获取到的Cookie: " + String.valueOf(cookies));
        if (cookies != null){
            logger.info("开始遍历");
            // 遍历
            for (Cookie cookie : cookies) {
                logger.info("当前cookie的值: " + cookie.getValue() + " 名字为:" + cookie.getName());
                // 判断是否有token
                if (cookie.getName().equals("token")){
                    String base64token = cookie.getValue();
                    logger.info("token的base64加密value : " + base64token);
                    String DEStoken = DESUtil.toHexString(Base64.decodeBase64(base64token)).toUpperCase();
                    logger.info("token的去base64后的加密value: " + DEStoken);

                    String token = java.net.URLDecoder.decode(DESUtil.decrypt(DEStoken,"zhongwei"), "utf-8");
                    logger.info("token的解密value:" + token);

                    // 分割字符串 获取id
                    Integer id = Integer.valueOf(token.split("|")[0]);
                    Integer id1 = Integer.valueOf(token.split("|")[2]);
                    logger.info("id为: " + id);
                    logger.info("id1为: " + id1);
                    if(id == id1){
                        return true;
                    }
                }
            }
        }
        // token验证失败 跳回登陆页面
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/main");
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
