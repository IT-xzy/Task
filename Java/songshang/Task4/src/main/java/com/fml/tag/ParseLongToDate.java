package com.fml.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseLongToDate extends TagSupport {
    private long value;

    private String pattern;

    public void setValue(long value) {
        this.value = value;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int doStartTag() throws JspException {
        if (pattern == null || pattern == ""){
            throw new RuntimeException("pattern must be not empty!");
        }

        if (pattern.equals("yyyy-MM-dd HH:mm:ss") || pattern.equals("yyyy-MM-dd EE") || pattern.equals("yyyy-MM-dd") || pattern.equals("yy-MM-dd HH:mm:ss")){
            Date date = new Date(value);
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            String datetime = dateFormat.format(date);
            JspWriter out = this.pageContext.getOut();
            try {
                out.print(datetime);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            throw new RuntimeException("pattern is not allowed type!");
        }
        return super.doStartTag();
    }
}
