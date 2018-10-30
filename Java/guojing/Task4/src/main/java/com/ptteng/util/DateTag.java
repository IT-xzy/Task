package com.ptteng.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateTag extends TagSupport {


//    value的类型最好是写为String，改为long在本地是好的，在服务器上就不行了
    private String value;

//    重写TagSupport的doStartTag方法，转换时间的数据类型
    @Override
    public int doStartTag() throws JspException {

//      转换数据类型，先转换为包装类Long，在转换为long型数据
        long time = Long.valueOf(value);
        /*通过getInstance方法生成Calendar子类的实例，不能直接获取Calendar的实例，
         * 因为Calendar是一个抽象类（主要操作日期和时间字段）*/
        Calendar c = Calendar.getInstance();
//        将时间转化为毫秒
        c.setTimeInMillis(time);
//        设置时间格式，通过simpleDateFormat的format方法转换时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
//转换时间格式
        String s = dateFormat.format(c.getTime());
        try {
//            将转化格式的时间写入jsp页面中
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
