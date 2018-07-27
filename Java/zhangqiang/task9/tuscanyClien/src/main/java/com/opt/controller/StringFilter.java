package com.opt.controller;


import com.opt.util.FilterStringUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 过滤器
 *
 * @Title: 过滤器
 * @Description: 过滤敏感字符
 * @author By.ZhangQiang
 * @date 2018-5-28
 */
public class StringFilter implements Filter {

    private final Logger logger = Logger.getLogger(StringFilter.class);
    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.info("\n Filter初始化>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String note =  request.getParameter("note");
        logger.info("\n过滤器开始执行 获取参数为： >>>>>>>>>>> " + note + " <<<<<<<<<<\n");

        if (null != note) {
            logger.info("\n >>>>>>>>>>> " + note + " <<<<<<<<<<");

            List<String> list = FilterStringUtil.getFilterString();

            for(String str : list){
                note = note.replace(str,"[替換]");
            }
            logger.info("\n替換后的字符串：" + note);
            request.setAttribute("note",note);
        }else {
            logger.info("\n未匹配到敏感字符\n");
        }

        logger.info("\n过滤器过滤完毕,开始执行doFilter\n");

        chain.doFilter(request, response);

        FilterConfig filterConfig = null;
//        filterConfig.getFilterName();
    }

    @Override
    public void destroy() {

    }
}



