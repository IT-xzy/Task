package com.lihoo.ssm.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * #Title: DateTag
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/29-16:40
 */

@SuppressWarnings("unused")


public class DateTag extends TagSupport {
    private static final long serialVersionUID = 6464168398214506236L;
    private String value;
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try {
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }


}
