package com.jnshu.Tag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends SimpleTagSupport {
    //重写SimpleTagSupport类里面的doTag方法，创建自己的时间获取方法：
    @Override
    public void doTag() throws JspException, IOException {
        PageContext ctx = (PageContext) getJspContext();
        JspWriter out = ctx.getOut();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        out.println(sdf.format(new Date()));
    }
}
