package com.interceptor;/*
 * @ClassName:PeopleInterceptor
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/9 17:44
 **/

import com.util.DESUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class PeopleInterceptor implements HandlerInterceptor {
    private static Logger logger = Logger.getLogger("LoginInterceptor.class");

    /**
     * @param
     * @return
     * @mathodName preHandle
     * @Description 登录拦截器
     * @date 2018/8/3 21:15
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        Cookie[] cookies = request.getCookies();
        DESUtil desUtil = new DESUtil();

        //非空验证
        if (cookies == null) {
            logger.info("没有cookie==============");
        } else {
            logger.info("有cookie=========");
            String name = "";
            String token = "";
            //遍历cookie如果找到登录状态则返回true执行原来controller的方法
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    //在页面显示登录用户
                    name = desUtil.decrypt(cookie.getValue());
                    logger.info("登录用户name-------------" + name);
                }
                if (cookie.getName().equals("token")) {
                    logger.info("token验证" + cookie.getValue());
                    //token解密
                    token = cookie.getValue();
                    String str3 = desUtil.decrypt(token);
                    //取出用户name信息
                    String name2 = desUtil.decrypt(str3.split("\\|")[1]);
                    logger.info(name2);
                    //根据token解密后，验证用户name是否一致
                    if (name.equals(name2)) {
                        request.getSession().setAttribute("name", name);
                    }
                }
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {

    }
}
