package com.POJO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: Jaime
 * @Date: 2018/4/8 21:30
 * @Description: 标签处理类*
 */
public class DateTag extends TagSupport{
    private static final long serialVersionUID = 6464168398214506236L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = ""+value ;
        long time = Long.valueOf(vv);
        //getInstance()使用默认时区和语言环境获得一个日历。返回的 Calendar 基于当前时间，使用了给定时区和默认语言环境。
        Calendar c = Calendar. getInstance();
        //setTimeInMillis()用给定的 long 值设置此 Calendar 的当前时间值。
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String s = dateformat.format(c.getTime());
        try {
            //涉及到Out对象。这里运用pageContext对象获取out对象，写入s;
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
