package com.suger.util;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author suger
 * @date 2018/11/18 15:29
 *
 * 用于jsp时间 格式化
 */
public class DateTag  extends TagSupport{

    private static Logger logger = Logger.getLogger(DateTag.class);
    private String value;

    // 重写doStartTag方法,通过jsp标签把long类型转换为String直接输出
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try {
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("时间转化失败");
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        long time = Long.valueOf(a);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat =new SimpleDateFormat("MM-dd HH:mm");
        String s = dateformat.format(c.getTime());
        System.out.println(s);
        }
}
