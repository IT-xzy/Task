package org.wyq.task.datetag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport{

    private static final long serialVersionUID = -818658804117151461L;

    private String value;

    @Override
    public int doStartTag() throws JspException{
        String vv = "" + value;
        try{
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            String s = dateFormat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e){
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value){
        this.value = value;
    }
}
