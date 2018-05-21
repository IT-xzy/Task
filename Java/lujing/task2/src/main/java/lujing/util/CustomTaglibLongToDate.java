package lujing.util;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lujing
 * Create_at 2018/1/2 14:45
 */
public class CustomTaglibLongToDate extends TagSupport {
    private String value;
    
    private String pattern;
    
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    
    /**
     * 自定义时间转换类型
     *
     * @return
     * @throws JspException
     */
    
    @Override
    public int doStartTag() throws JspException {
        String vv = value;
        if (vv.length() != 0 ) {
            long time = Long.valueOf(vv);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
            String s = dateformat.format(c.getTime());
    
            try {
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                pageContext.getOut().write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      
        return super.doStartTag();
        
    }
    
}
