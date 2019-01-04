package com.jnshu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
                System.out.println("----过滤器初始化----");
            }
    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {

        // 对request、response进行一些预处理
        var2.setCharacterEncoding("UTF-8");
        var2.setCharacterEncoding("UTF-8");
        var2.setContentType("text/html;charset=UTF-8");

       // filterChain.doFilter(request, response); // 执行目标资源，放行

        HttpServletRequest req = (HttpServletRequest)var1;
        HttpSession session = req.getSession();
        String state = (String)session.getAttribute("state");
        System.out.println("----调用service之前执行一段代码----");
        if(state.equals("1")){
            var3.doFilter(var1,var2);
        }else{
            HttpServletResponse response =  (HttpServletResponse)var2;
            response.sendRedirect("/task6/Error_page.html");
        }
        System.out.println("----调用service之后执行一段代码----");
    }
    @Override
     public void destroy() {
                System.out.println("----过滤器销毁----");
             }
}

