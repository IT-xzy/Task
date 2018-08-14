package com.fgh.task2.tool;



import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
//    private static final long serialVersionUID = 6464168398214506236L;

    private String value;
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        if( vv!= null && !vv.isEmpty())
        try {
            long time = Long.valueOf(vv.trim());
//            创建 Calendar 对象
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time * 1000);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd ");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}

