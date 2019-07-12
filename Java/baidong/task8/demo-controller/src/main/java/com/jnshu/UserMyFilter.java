package com.jnshu;


import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class UserMyFilter implements Filter {
       private static final Logger logger = Logger.getLogger(UserMyFilter.class);



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化=========");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("过滤器正在执行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("过滤器被销毁了=======");

    }
}
