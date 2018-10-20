package cn.wyq.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private String value;
    private String pattern;

    public static String getFormatDate(long l, String formatStr){
        Date d = new Date(l);
        String date = new SimpleDateFormat(formatStr).format(d);
        return date;
    }

    @Override
    public int doStartTag() throws JspException {
        long l = 0l;
        if(StringUtils.isNotBlank(value)){
            l = Long.parseLong(value);
        }

        if(StringUtils.isBlank(pattern)){
            pattern = DEFAULT_FORMAT;
        }

        String targetTime = " ";

        if(l>0l){
            targetTime = getFormatDate(l,pattern);
        }

        try {
            super.pageContext.getOut().write(targetTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
