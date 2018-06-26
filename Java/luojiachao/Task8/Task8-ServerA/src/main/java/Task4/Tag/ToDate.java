package Task4.Tag;

import org.apache.ibatis.ognl.ParseException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ToDate extends SimpleTagSupport{
    private Long time;

    public void setTime(Long time) {
        this.time = time;
    }


    public void doTag() throws JspException, IOException {
        try {
            String date=TimeTag.longToString(time);
            JspWriter out=getJspContext().getOut();
            out.print(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    }

