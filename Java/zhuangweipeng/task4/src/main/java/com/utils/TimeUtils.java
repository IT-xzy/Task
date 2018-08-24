package com.utils;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.util.SocketUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils extends TagSupport {

    private  Long  value;

    public void setValue(Long value){
        this.value = value;
    }
    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value==null) {
            Date date = new Date();
            String string = simpleDateFormat.format(date);
            System.out.println("value==null:"+date);
            try {
                pageContext.getOut().print(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Date date = new Date(value);
            String string = simpleDateFormat.format(date);
            System.out.println("value:"+value);
            try {
                pageContext.getOut().print(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doStartTag();
    }
}
