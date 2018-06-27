package com.alibaba.util;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user =request.getParameter("user");
        String pass=request.getParameter("pass");
        String savetimeString=request.getParameter("savetime");

        if(new LoginBiz().isValid(user, pass)){
            int savetime=Integer.parseInt(savetimeString)*24*3600;
            Cookie loginInfo=new Cookie("loginInfo",user+","+pass);
            loginInfo.setMaxAge(savetime);
            response.addCookie(loginInfo);
            response.sendRedirect("/WEB-INF/view/CustomerForm.jsp");
        }else{
            response.sendRedirect("/WEB-INF/view/login.jsp");
        }
    }
}
