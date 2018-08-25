package com.jnshu.tools;

import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户登录拦截器
 *
 * @author tb
 * 这里注意：拦截器是运行在springmvc，是由子容器springmvc管理，而属性文件是由父容器spring管理所以如果要在拦截器中注入属性文件，
 * 需要在子容器springmvc的配置文件中再扫描一遍属性文件。
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;


    /**
     * 执行时机：Handler执行之前执行该方法 返回值：true（放行）/false（拦截）
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object arg2) throws Exception {
        System.out.println("进入拦截方法");
        Cookie[] cookies = request.getCookies();
        String loginInfo;
        String username = null;
        Long time = System.currentTimeMillis();
        System.out.println("初始化"+time);
        DESUtil desUtil = new DESUtil();
        DateTag date = new DateTag();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookie")) {
                loginInfo = desUtil.decrypt(cookie.getValue());
                username = loginInfo.split(",")[0];
                time = Long.valueOf(loginInfo.split(",")[1]);
                request.setAttribute("username", username);
                request.setAttribute("time", time);
                System.out.println(username);
                break;
            }
        }

        System.out.println("获取"+time);
        long dateDifference = System.currentTimeMillis() - time;//计算时间差
        System.out.println(dateDifference);
        User user = userService.selectByName(username);
        System.out.println(username);
        if (user == null|dateDifference>3600000) {
            /*
             * 用户没登录，跳转到登录页面（使用重定向，因为这里跨系统了也就是不是在一个工程内部）
             * 要携带参数：redirectURL。（上一个页面的url，也就是发出当前Request请求的url，
             * 用于登录完成后返回之前的页面继续操作。）
             */
            return false;// 拦截用户，不可执行该Handler
        }
        response.sendRedirect("index.jsp");
        // 用户已经登录，放行。
        return true;
    }

    /**
     * 执行时机：在Handler返回之后，但是在Handler返回ModelAndView之前 Handler已经执行完了也没什么拦截不拦截的了
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 执行时机：完全完成Handler处理，已经返回ModelAndView
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }


    @RequestMapping("/page/login")
    public String showLogin(String redirectURL, Model model) {
        return "login";
    }


}

