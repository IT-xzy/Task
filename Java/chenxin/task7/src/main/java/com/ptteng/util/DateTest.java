package com.ptteng.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest extends SimpleTagSupport {

    //按照传入数据来格式化时间
    private Long timeMillis;

    public Long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(Long timeMillis) {
        this.timeMillis = timeMillis;
    }

    public void doTag() throws JspException,IOException {
        Date date = new Date(timeMillis);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年-MM月-dd日");
        String dateText = simpleDateFormat.format(date);
        getJspContext().getOut().write(dateText);
    }
}
