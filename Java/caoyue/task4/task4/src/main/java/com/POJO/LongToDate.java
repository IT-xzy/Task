package com.POJO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author: 曹樾
 * @program: task4
 * @description: long转化为date类型显示在jsp上
 * @create: 2018/4/26 下午3:51
 */

public class LongToDate extends TagSupport{
    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long serialVersionUID = 6464168398214506236L;
    private String value;
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try{
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String s = dateFormat.format(c.getTime());
            pageContext.getOut().write(s);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
