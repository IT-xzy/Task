package com.alibaba.Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends SimpleTagSupport{
    public void doTag() throws JspException, IOException {
        //当前页面无法传参；request，可以传参
        //Tag文件为了给JSP页面返回一个对象，就必须将对象的名字以及该对象的引用存储到TomCat引擎提供的内置对象jspContext中
        PageContext ctx = (PageContext) getJspContext();
        //JspWriter可以在JSP页面中直接用out对象输出.可以用pageContext.getOut();得到JspWriter对象
        JspWriter out = ctx.getOut();
        //字符串转日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        out.println(sdf.format(new Date()));
    }
}
