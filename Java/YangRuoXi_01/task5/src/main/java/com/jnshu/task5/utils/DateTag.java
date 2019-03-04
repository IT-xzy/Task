package com.jnshu.task5.utils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends SimpleTagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws IOException {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(Long.parseLong(value));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date.getTimeInMillis());
        JspWriter out = getJspContext().getOut();
        out.println(time);
    }

}
