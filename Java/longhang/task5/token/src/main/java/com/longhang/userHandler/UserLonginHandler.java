package com.longhang.userHandler;

import com.longhang.server.UserService;
import com.longhang.util.Md5Utils;
import com.longhang.util.Token;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLonginHandler extends UserHandler{
    @Resource
    private UserService userSe;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        String s =  request.getParameter("name");
        String password=request.getParameter("password");
        System.out.println(s);
        System.out.println(password);
        Token t=new Token();
        Md5Utils md=new Md5Utils();
        String name1=t.makeToken(s);
        String password1=md.MD5(t.makeToken(password));
        //没有该用户
        if(!userSe.getGetAllName().contains(name1))
        {request.getRequestDispatcher("/WEB-INF/pages/noUser.jsp").forward(request, response);
            return false;}
        //密码错误
            if(!(userSe.getSelectByName(name1).equals(password1)))
        { request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
            return false;}
        return true;
        }
    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView modelAndView)throws Exception{
        Long a1= (Long) modelAndView.getModel().get("time");
        String a2=(String) modelAndView.getModel().get("name");
        System.out.println(a2);
        Token tk=new Token();
        //把登录时间作为密码
        String psw=tk.makeToken(String.valueOf(a1));
        String name=tk.makeToken(a2);
        //cookie添加用户名
        Cookie userCookie=new Cookie("userName",name);//添加用户名
        userCookie.setMaxAge(7*24*60*60);
        response.addCookie(userCookie);
        //cookie添加登录时间
        Cookie c = new Cookie("key",psw);//添加登录时间
        c.setMaxAge(7*24*60*60);
        response.addCookie(c);
        request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
        }
}
