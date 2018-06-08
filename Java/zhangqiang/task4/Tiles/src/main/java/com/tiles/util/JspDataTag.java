package com.tiles.util;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 用于jsp 时间格式化
 *
 * @Title: JSTLDateUtils.java
 * @Description: TODO(转换jsp的时间格式)
 * @author By.ZhangQiang(张强)
 * @date 2018 -5- 24 19:24:51
 */
public class JspDataTag extends TagSupport {

    private static Logger logger = Logger.getLogger(JspDataTag.class);
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

//    重写doStartTag方法,通过jsp标签把long类型转换为String直接输出
    @Override
    public int doStartTag() throws JspException {
        String val = "" + value;
        try {
            long time = Long.valueOf(val.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("转换失败");
        }
        return super.doStartTag();
    }


}
