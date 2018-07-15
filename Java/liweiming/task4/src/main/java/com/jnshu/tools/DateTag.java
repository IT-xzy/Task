package com.jnshu.tools;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间转换类
 * @author Mason
 * @date 2018/06/26
 * */
public class DateTag extends TagSupport{
    private String value;

    @Override
    public int doStartTag () throws JspException {

        String vv = "" + value;
        try {
            if (!vv.trim().isEmpty()) {

                Long time = Long.valueOf( vv.trim());

                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(time);

                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                String s = dateformat.format(c.getTime());

                pageContext.getOut().write(s);
            }else {
                pageContext.getOut().write("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue (String value){
        this.value = value;
    }
}
