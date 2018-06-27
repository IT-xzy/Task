package com.fgh.task2.tool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
//    private static final long serialVersionUID = 6464168398214506236L;
Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private String value;
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        logger.debug("vv:"+vv);
        try {
            long time = Long.valueOf(vv.trim());
//            创建 Calendar 对象
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time * 1000);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd ");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}

