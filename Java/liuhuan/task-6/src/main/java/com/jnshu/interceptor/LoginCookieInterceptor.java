package com.jnshu.interceptor;

import com.jnshu.service.UserService;
import com.jnshu.tools.DESUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: taskTwo
 * @description: 登陆拦截器 Cookie方式
 * @author: Mr.xweiba
 * @create: 2018-05-21 16:03
 **/

public class LoginCookieInterceptor implements HandlerInterceptor {
    @Qualifier("userServiceMemcacheImpl")
    @Autowired
    UserService userService;

    //计算时间
    private Long timer = Long.valueOf(0);

    private static Logger logger = LoggerFactory.getLogger(LoginCookieInterceptor.class);


    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //handler 开始时间
        this.timer = System.currentTimeMillis();

        // 判断Cookie
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
                    String token = java.net.URLDecoder.decode(DESUtil.decrypt(DEStoken,"liuhuan1"), "utf-8");
                    logger.info("token的解密value:" + token);
                    // 分割字符串 获取id
                    Integer id = Integer.valueOf(token.split("=")[0]);
                    logger.info("id为: " + id);
                    if(userService.findUserAuthByid(id)){
                        return true;
                    }
                }
            }
        }
        // token验证失败 跳回登陆页面
        // httpServletRequest https://blog.csdn.net/gris0509/article/details/6340987
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
        //return false表示拦截，不向下执行 此时应计算页面结束时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.debug( "性能日志 页面生成时长 : " + this.timer + "ms" );
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //执行完毕时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.debug("性能日志 页面生成时长 : " + this.timer + "ms");
    }
}
