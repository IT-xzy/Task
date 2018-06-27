package com.ev.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeFormatTag extends SimpleTagSupport {

    private Long time;

    public void setTime(Long time) {
        this.time = time;
    }

    StringWriter sw=new StringWriter();

    public void doTag() throws JspException, IOException{
        try {
            String date=TimeFormatUtil.longToString(time);
            JspWriter out=getJspContext().getOut();
            out.print(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
