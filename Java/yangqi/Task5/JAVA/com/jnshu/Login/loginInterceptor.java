package com.jnshu.Login;

import com.jnshu.entity.User;
import com.jnshu.service.userService;
import com.jnshu.util.CookieUtil;
import com.jnshu.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginInterceptor implements HandlerInterceptor {

    @Autowired
    public userService userService;

    private static Logger logger = LoggerFactory.getLogger(loginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)throws Exception {

        String requestURL = httpServletRequest.getRequestURI();
        //不拦截页面
        String[] noFilters = new String[]{"login", "doLogin", "static", "register", "Register"};
        //判断是否处在登录编辑页面
        for (String s : noFilters) {
            //判断url 是否放行
            if (requestURL.indexOf(s) > 0) {
                logger.info("进入到拦截方法");
                return true;
            }
        }
        //如果其他页面
        //如果放行执行下面的方法
        logger.info("进入方法？？？？？？？？？？？、");
        //获取请求的路径
        String path = httpServletRequest.getContextPath();
        //调用cookie里的方法 获取cookie请求token，
        Cookie token = CookieUtil.getCookieByName(httpServletRequest, "token");
        //判断token是否为空
        if (token != null) {
            logger.info(token.getValue() + "皮皮虾我们走，好的我们走啦~ 出来出来。。。。");
            //加密Token ，获取token的值
            String tokeData = token.getValue();
            //解密token 调用token工具类解密
            String enTokenData = TokenUtil.enToken(tokeData);
            //字符串分割
            String[] strings = enTokenData.split("/");
            String id = strings[0];
            //String转换成long
            long l_id = Long.parseLong(id);
            logger.info(id + "id？出来了？终于出来了");
            //查询数据表里的id，
            User user = userService.selectByid(l_id);
            //如果这个表里的数据 为空的话
            if (user == null) {
                //使用Cookie工具类 创建一个token
                CookieUtil.addCookie(httpServletResponse, "token", null, 0);
                try {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpServletRequest.getSession().setAttribute("errorInfo", "请登录");
                return false;
            }
            //如果条件成立就放行，
            else {
                logger.info("这个人是存在的");
                return true;
            }

        } else {
            logger.info("token没有内容");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return false;
        }
    }

    //进入handler 方法之后，返回modelAndview之前执行
    //应用场景从modelAndView出发：将公用的模型数据（菜单导航）在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)throws Exception {
        logger.info("test postHandle 拦截器执行了,进入Handler方法之后，返回modelAndView之前执行");
    }

    //执行handler完成执行此方法
    //应用场景:统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e)throws Exception{
        logger.info("HandlerInterceptor1 afterCompletion 拦截器执行了,Handler运行完成后执行此方法");
    }

}
