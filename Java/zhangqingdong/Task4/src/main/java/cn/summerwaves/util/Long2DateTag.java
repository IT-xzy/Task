package cn.summerwaves.util;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;
import java.text.SimpleDateFormat;

public class Long2DateTag extends SimpleTagSupport {
    private Long time;

    public void setTime(Long time){
        this.time = time;
    }

    @Override
    public void doTag() throws JspException , IOException {
        JspWriter out = getJspContext().getOut();
        out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(time));
    }

}
