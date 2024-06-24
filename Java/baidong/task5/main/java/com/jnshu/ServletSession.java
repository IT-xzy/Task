package com.jnshu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//Content-Type
//用于定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件
//CharacterEnc oding
//作用是设置对客户端请求进行重新编码的编码
//也就是说一个是设置读，一个是设置取
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//        req.getSession()方法会获取到session对象，如果没有session对象，就会直接创建一个session对象
        HttpSession session = req.getSession();
//将数据放进去
        session.setAttribute("data", "suibianfangyige");
//        获取到Sesion的id
        String sessionId = session.getId();
//        判断session是不是新的
        if (session.isNew()) {
            resp.getWriter().print("session创建成功，session的id是：" + sessionId);
        } else {
            resp.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
