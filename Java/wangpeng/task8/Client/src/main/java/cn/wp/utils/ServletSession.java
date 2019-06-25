package cn.wp.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/24 17:05
 * @Version: 1.0
 */
public class ServletSession extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
//        将数据存储到session中
        session.setAttribute("data", "随便");
//        获取session的Id
        String sessionId = session.getId();
//        判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是：" + sessionId);
        } else {
            response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}