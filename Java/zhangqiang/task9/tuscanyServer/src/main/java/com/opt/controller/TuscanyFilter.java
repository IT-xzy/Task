package com.opt.controller;

import org.apache.log4j.Logger;
import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.InvalidClassException;

public class TuscanyFilter implements Filter {
    private static Logger logger = Logger.getLogger(TuscanyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("启动filter tuscanyService服务");
//        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        System.setProperty("java.rmi.server.hostname", "47.98.50.21");
//        System.setProperty("java.rmi.server.hostname", "119.29.17.188");
        Node node = NodeFactory.newInstance().createNode("tuscany/Computer.composite");
        node.start();

        logger.info("发布tuscanyService服务成功！");
    }

    @Override
    public void destroy() {

    }
}
