package com.jnshu.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 自定义jsp标签*/
public class DateTag extends TagSupport {
    //jsp传过来的是字符串类型
    private static final long seriaVersionUID = 6464168398214506236L;
    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try {
            //将字符串转换为long trim()除去空格,转换时不能有空格
            long time = Long.valueOf(vv.trim());
            //System.out.println(timeLong)
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date jut = new Date(time * 1000);
            String s = dateFormat.format(jut);
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
