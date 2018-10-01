package com.jnshu.tiles.interceptor;

import com.jnshu.tiles.tools.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Tiles
 * @description: 登录拦截
 * @author: Mr.Lee
 * @create: 2018-07-07 10:32
 **/
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    //Controller执行的全过程都在这里,可以用作执行时间日志
    //计算时间
    private Long timer = Long.valueOf(0);

    /**
    * @Description: 执行Handler方法之前，用于身份认证、身份授权
    * @Param: [httpServletRequest, httpServletResponse, o] 
    * @return: boolean 
    * @Author: Mr.Lee
    * @Date: 2018\7\7 0007 
    */ 
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getServletPath().endsWith("profession")){
            logger.info("请求已进入拦截器！");

            Cookie cookies = CookieUtil.getCookieByName(httpServletRequest,"tokens");

            if (cookies == null){
                logger.info("用户还未登录或cookie已失效，需重新登录!");
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/viewLogin");
                return false;
            }
            //如果cookie存在，直接登录
            String tokens = cookies.getValue();
            logger.info("tokens"+tokens);
            logger.info("token有效，用户可以登录！");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //执行完毕时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.info("HandlerInterceptor1 afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
        logger.debug("性能日志 页面生成时长 : " + this.timer + "ms");
    }

}
