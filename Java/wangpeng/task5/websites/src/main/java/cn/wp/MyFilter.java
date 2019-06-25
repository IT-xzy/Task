package cn.wp;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/24 17:07
 * @Version: 1.0
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter运行中======================");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter已销毁=====================");
    }
}
