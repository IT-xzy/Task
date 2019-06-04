package com.jnshu.pojo.tool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author pipiretrak
 * @date 2019/4/1 - 2:05
 */
public class TimeUtil extends TagSupport {
    private Long value;

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value==null) {
            Date date = new Date();
            String s = simpleDateFormat.format(date);
            System.out.println("value==null:"+date);
            try {
                pageContext.getOut().print(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Date date = new Date(value);
            String s = simpleDateFormat.format(date);
            System.out.println("value:"+value);
            try {
                pageContext.getOut().print(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doStartTag();
    }
}
