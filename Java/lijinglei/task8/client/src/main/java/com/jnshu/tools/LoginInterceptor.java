package com.jnshu.tools;

import com.jnshu.RMIClient;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 用户登录拦截器
 *
 * @author tb
 * 这里注意：拦截器是运行在springmvc，是由子容器springmvc管理，而属性文件是由父容器spring管理所以如果要在拦截器中注入属性文件，
 * 需要在子容器springmvc的配置文件中再扫描一遍属性文件。
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 执行时机：Handler执行之前执行该方法 返回值：true（放行）/false（拦截）
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object arg2) throws Exception {
        try {


            RMIClient rmiClient = RMIClient.server();
            UserService userService = rmiClient.getUserService();
            System.out.println("进入拦截方法");
            Long time = System.currentTimeMillis();
            System.out.println("初始化" + time);
            HttpSession session = request.getSession();
            String se = (String) session.getAttribute("session");
            System.out.println(se);
            if (se != null) {
                System.out.println("session");
                String username = se.split(",")[0];
                String password = se.split(",")[1];
                time = Long.valueOf(se.split(",")[2]);
                User user = userService.selectByName(username);
                long dateDifference = System.currentTimeMillis() - time;//计算时间差
                System.out.println(dateDifference);
                System.out.println(username);
                System.out.println(user.getPassword());
                System.out.println(password);
                request.setAttribute("username", username);
                if (user.getPassword().equals(password) && dateDifference < 3600000) {
                    return true;
                }
                response.sendRedirect("/toLogin");
                return false;// 拦截用户，不可执行该Handler
            }

            response.sendRedirect("/toLogin");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            response.sendRedirect("/toResult");
            return false;
        }
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

