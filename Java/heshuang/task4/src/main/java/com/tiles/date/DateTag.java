package com.tiles.date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {
    private String pattern;
    private Long value;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public int doStartTag()throws JspException{
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String s = dateFormat.format(new Date(value));
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}


