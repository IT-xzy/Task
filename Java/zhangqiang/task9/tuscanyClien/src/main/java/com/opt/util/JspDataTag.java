package com.opt.util;

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

//    jsp标签页里面传入的value属性的值
    public void setValue(String value) {
        this.value = value;
    }

//    重写doStartTag方法,通过jsp标签把long类型转换为String直接输出
    @Override
    public int doStartTag() throws JspException {
        String val = "" + value;
        try {

//            转换long类型
            long time = Long.valueOf(val.trim());

//            获取时间进行转换 Calendar是一个抽象类，主要用来操作日历时间字段
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = dateformat.format(calendar.getTime());

//          pageContext是父类TagSupport的受保护属性 pageContext 存取其他隐含对象，这里输出到前台
            pageContext.getOut().write(str);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("转换失败");
        }
        return super.doStartTag();
    }


}
