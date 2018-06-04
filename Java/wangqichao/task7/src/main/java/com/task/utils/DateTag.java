package com.task.utils;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.jar.JarException;

/**
 * 设置时间戳转化标签
 */
public class DateTag extends TagSupport {
//为了验证版本一致性而设置的
    private static final long serialVersionUID = 6464168398214506236L;
//此value属性用来接收jsp的传参
    private String value;
    private Logger logger= Logger.getLogger(DateTag.class);
@Override
    public int doStartTag()throws JspException{
    //将value转化为字符串形式
    String vv=""+value;
    try{
        long time=Long.valueOf(vv.trim());
        Calendar c=Calendar.getInstance();
        c.setTimeInMillis(time);
        //设置想要设置的时间输出形式
       // SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        //转化time为格式时间
        String s = dateformat.format(c.getTime());
        pageContext.getOut().write(s);
    }catch(Exception e){
        e.printStackTrace();
        logger.error("转化时间错误");
    }
    return super.doStartTag();
}
//设置set方法接收value
    public void setValue(String value) {
        this.value = value;
    }
}
