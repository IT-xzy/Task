package com.ptteng;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @ClassName test
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  11:46
 * @Version 1.0
 **/
public class test extends TagSupport{
    private PageContext pageContext;
    @Override
    public void setPageContext(PageContext pageContext){
        this.pageContext = pageContext;
    }
    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getResponse().getWriter().write("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return super.doStartTag();
    }
    }
