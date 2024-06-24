package com.jnshu;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DataTag extends TagSupport {
    private Long value;

    @Override
    public int doStartTag() throws JspException {
//        设置日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//用format方法来进行转化格式
        String s = dateFormat.format(System.currentTimeMillis());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    //set方法,设置值
    public void setValue(Long value) {
        this.value = value;
    }


}
