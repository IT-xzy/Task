package com.jnshu.interceptor;

import com.jnshu.service.UserService;
import com.jnshu.tools.DESUtil;
import com.jnshu.tools.MemcacheUtils;
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
import javax.servlet.http.HttpSession;

/**
 * @program: taskTwo
 * @description: 登陆拦截器 Cookie配合Session
 * @author: Mr.xweiba
 * @create: 2018-05-24 23:16
 **/

public class LoginInterceptor implements HandlerInterceptor {
    @Qualifier("userServiceMemcacheImpl")
    @Autowired
    UserService userService;
    @Autowired
    MemcacheUtils memcacheUtils;

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
        HttpSession session = httpServletRequest.getSession();
        // 同一用户只有一个随机session id, 判断 session id是否已缓存, 减少Cookie解密开销
        if(memcacheUtils.get(session.getId())!=null){
            logger.info("Session 效验通过");
            return true;
        }

        // session无法找到验证Cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        // logger.info("Cookie长度为: " + cookies.length);
        // logger.info("拦截器获取到的Cookie: " + String.valueOf(cookies));
        if (cookies != null){
            // logger.info("开始遍历");
            // 遍历
            for (Cookie cookie : cookies) {
                // logger.info("当前cookie的值: " + cookie.getValue() + " 名字为:" + cookie.getName());
                // 判断是否有token
                if (cookie.getName().equals("token")){
                    String base64token = cookie.getValue();
                    // logger.info("token的base64加密value : " + base64token);
                    String DEStoken = DESUtil.toHexString(Base64.decodeBase64(base64token)).toUpperCase();
                    // logger.info("token的去base64后的加密value: " + DEStoken);
                    String token = java.net.URLDecoder.decode(DESUtil.decrypt(DEStoken,"liuhuan1"), "utf-8");
                    // logger.info("token的解密value:" + token);
                    // 分割字符串 获取id
                    Integer id = Integer.valueOf(token.split("=")[0]);
                    // logger.info("id为: " + id);

                    if(userService.findUserAuthByid(id)){
                        logger.info("Cookie效验通过");
                        // 登陆成功 重新设置Session缓存
                        // 在session中保存用户身份信息
                        // 这里偷 直接拿值不遍历了 实际项目也不会用session存储信息了
                        session.setAttribute("username", cookies[0].getValue());
                        // logger.info("session.getId():" + session.getId());
                        // 存入缓存 用作效验
                        memcacheUtils.set(session.getId(), cookies[0].getValue());
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
        logger.info( "性能日志 页面生成时长 : " + this.timer + "ms" );
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // logger.info("LoginInterceptor postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //执行完毕时间
        this.timer = System.currentTimeMillis() - this.timer;
        logger.info("性能日志 页面生成时长 : " + this.timer + "ms");
    }
}
