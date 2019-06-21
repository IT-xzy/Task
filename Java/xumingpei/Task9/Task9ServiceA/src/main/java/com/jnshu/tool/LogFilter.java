package com.jnshu.tool;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获得初始化参数
        String site = filterConfig.getInitParameter("Site");
        //输出初始化参数
        System.out.println("网站名称："+site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
