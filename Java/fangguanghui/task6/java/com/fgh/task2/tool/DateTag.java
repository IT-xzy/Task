package com.fgh.task2.tool;


//|| !value.equals("breakdown")
import com.fgh.task2.controller.RedisControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
//    private static final long serialVersionUID = 6464168398214506236L;
      Logger logger=LoggerFactory.getLogger(RedisControl.class);
    private String value;
    @Override
    public int doStartTag() throws JspException {
        if( value != null && !value.trim().isEmpty() && !value.equals("breakdown")) {
        String vv = "" + value;
            try {
                long time = Long.valueOf(vv.trim());
//            创建 Calendar 对象
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(time * 1000);
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd ");
                String s = dateformat.format(c.getTime());
                pageContext.getOut().write(s);
            } catch (Exception e) {
                logger.debug("转换失败");
                e.printStackTrace();
            }

        }else {
            logger.debug("字符串为空，无法转换");
        }

        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}

