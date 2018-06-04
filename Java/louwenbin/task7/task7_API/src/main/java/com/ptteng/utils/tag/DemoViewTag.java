package com.ptteng.utils.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author louisliao
 */
public class DemoViewTag extends TagSupport {
    private long time;

    public void setTime(long time) {
        this.time = time;
    }

    public int doEndTag() throws JspException  {
        //long time = System.currentTimeMillis();
        SimpleDateFormat matter = new SimpleDateFormat("现在时间:yyyy年MM月dd日E HH时mm分ss秒");
        Date date = new Date(time);
        JspWriter writer = pageContext.getOut();
        try {
            writer.print(matter.format(date));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.EVAL_PAGE;
    }
}
