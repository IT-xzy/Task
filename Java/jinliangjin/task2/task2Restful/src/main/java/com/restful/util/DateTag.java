package com.restful.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.util
 * @ClassName: DateTag
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:53
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:53
 * @UpdateRemark:
 * @Version: 1.0
 */
public class DateTag extends TagSupport{
    private static final long serialVersionUID = 6464168398214506236L;
    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        long time = Long.valueOf(vv);
        //getInstance()，静态方法，使用默认时区和语言环境获得日历
        Calendar c = Calendar.getInstance();
        //将long类型的时间注入到日历中
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转换成"yyyy-MM-dd HH:mm:ss"的字符串
        String s = dateformat.format(c.getTime());
        try {
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
