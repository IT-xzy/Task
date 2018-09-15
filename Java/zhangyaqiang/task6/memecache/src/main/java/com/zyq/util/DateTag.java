package com.zyq.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//继承TagSupport类
public class DateTag extends TagSupport {
//    两个属性的名字
    private String pattern;
    private Long value;
//    从jsp页面获取两个属性的名字
    public void setValue(Long value) {
        this.value = value;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
//重写方法并在页面输出转换后的时间
    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern );
        String string = simpleDateFormat.format(new Date(value));
        try {
            pageContext.getOut().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
