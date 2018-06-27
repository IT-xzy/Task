package com.token.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {


    private static final long serialVersionUID =1L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = ""+value ;
        //转换成Integer类型
        long time = Long.valueOf(vv);
        //获得一个Calendar类型的通用对象
        Calendar c = Calendar. getInstance();
        //用给定的 long 值设置此 Calendar 的当前时间值。
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd " );
        String s = dateformat.format(c.getTime());
        try {
            //getOut()方法返回一个JspWriter类的实例对象
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
    public void setValue(String value) {
        this.value = value;
    }
}