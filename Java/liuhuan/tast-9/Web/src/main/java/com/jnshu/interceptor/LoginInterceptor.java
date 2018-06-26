package com.jnshu.interceptor;

import com.jnshu.service.ServiceCache;
import com.jnshu.service.ServiceDao;
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
import java.net.URLDecoder;

/**
 * @program: smsdemo
 * @description: 登陆拦截器
 * @author: Mr.xweiba
 * @create: 2018-05-30 13:49
 **/

public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Qualifier("serverCachedMem")
    @Autowired
    private ServiceCache serviceCache;

    @Qualifier("serverDao")
    @Autowired
    private ServiceDao serviceDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 判断session_id是否存在
        String session_id = httpServletRequest.getSession().getId();
        if (serviceCache.getKey(session_id) != null) {
            logger.debug("session验证成功");
            return true;
        }
        // 判断Cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies!=null){
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("token")){
                    // 反Base64 取出密文
                    String DESToken = DESUtil.toHexString(Base64.decodeBase64(cookie.getValue())).toUpperCase();
                    // 解密
                    String Token = URLDecoder.decode(DESUtil.decrypt(DESToken,"liuhuan1"), "utf-8");

                    // 获取id并验证
                    if(serviceDao.findUserAuthByid(Integer.valueOf(Token.split("=")[0]))){
                        // 保存到缓存
                        serviceCache.setDefault(session_id, "session_id");
                        logger.debug("Cookie验证成功");
                        return true;
                    }
                }
            }
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
        logger.debug("验证失败");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
