package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowHeader")
public class ShowHeader extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        //设置响应连接过来的编码格式
        response.setContentType("text/html;charset=utf-8");

        /*  PrintWriter它的实例就是向前台的JSP页面输出结果
         * 比如out.print("Hello World")；在JSP页面就会有Hello World这句话
        * */
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ShowHeader</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Header at " + request.getContextPath() + "</h1>");

        /*
        *  调用getHeaderNames方法获得header信息
        * */
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String param = e.nextElement();
            String value = request.getHeader(param);
            out.print(param + ": " + value + "<br/>");
        }
        out.println("</body>");
        out.println("</head>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }
}