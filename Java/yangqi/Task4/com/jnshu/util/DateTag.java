package com.jnshu.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 自定义jsp标签*/
public class DateTag extends TagSupport {
    //定义一个的大数
    private static final long seriaVersionUID = 6464168398214506236L;
    //定义一个值
    private String value;
    //定义一个方法
    @Override
    public int doStartTag() throws JspException {
        //这部操作暂时没看懂。是一个强制类型转换？但是value本身就是个string啊。
        String vv = "" + value;
        try {
            //将String(字符串）的类型转换为long
            long time = Long.valueOf(vv.trim());
            //SimpleDateFormat设置出一个时间格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date jut = new Date(time * 1000);
            //
            String s = dateFormat.format(jut);
            //继承JspException父类的方法。。在页面打印这个时间？
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //这是一个返回自己的方法。
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }
}
