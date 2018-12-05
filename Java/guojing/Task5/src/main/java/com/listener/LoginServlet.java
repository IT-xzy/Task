package com.listener;

import com.entity.User;
import com.service.UserService;
import com.util.JWT;
import com.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //初始化然后才可以使用注解获取service
    public void init() throws ServletException {
        super.init();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Autowired
    private UserService userService;

    static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("测试有没有进入LoginServlet");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        logger.info(user);
        String password = "";
        if (user.getName() == null || user.getPassword() == null) {
            response.sendRedirect("login.jsp");
            return;
        }
//      对姓名进行加密
        user.setName(MD5Util.MD5(user.getName()));
        logger.info(user.getName());
        logger.info(user.getPassword());
        try {
            String name = user.getName();
            System.out.println("name==============" + name);
            System.out.println("userService==============" + userService);
            User user1 = userService.login(name);
            if(user1==null){
                logger.info("用户名不存在");
                response.sendRedirect("login.jsp");
                return;
            }
            password = user1.getPassword();
        } catch (Exception e) {
            response.sendRedirect("login.jsp");
            return;
        }
//        验证登录输入的密码与数据库保存的密码是否一致
        if (MD5Util.verify(user.getPassword(), password)) {
            logger.info("登录成功");
            Cookie tokenCookie = new Cookie("token", JWT.createJWT(user.getName()));
            tokenCookie.setMaxAge(30 * 60);
            tokenCookie.setPath("/");
            response.addCookie(tokenCookie);
            HttpSession session = request.getSession();
            session.setAttribute("name", user.getName());//将属性保存到session会话中
            response.sendRedirect("/student");
            return;
        }
        logger.info("密码不正确");
        response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }


}
