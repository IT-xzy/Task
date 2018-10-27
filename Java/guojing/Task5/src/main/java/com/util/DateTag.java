package com.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateTag extends TagSupport {

//    private static final long serialVersionUID = 6464168398214506236L;

    private String value;

//    重写TagSupport的doStartTag方法，转换时间的数据类型
    @Override
    public int doStartTag() throws JspException {
//        参数类型转化，若value是String类型
        String vv = ""+value;
        long time = Long.valueOf(vv);
        /*通过getInstance方法生成Calendar子类的实例，不能直接获取Calendar的实例，
         * 因为Calendar是一个抽象类（主要操作日期和时间字段）*/
        Calendar c = Calendar.getInstance();
//        将时间转化为毫秒
        c.setTimeInMillis(time);
//        设置时间格式，通过simpleDateFormat的format方法转换时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String s = dateFormat.format(c.getTime());
//        String s = dateFormat.format(value);
        try {
//            将时间时间写入jsp页面中
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
