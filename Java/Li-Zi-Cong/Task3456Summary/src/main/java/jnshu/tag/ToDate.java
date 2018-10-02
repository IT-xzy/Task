package jnshu.tag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDate extends SimpleTagSupport{
    private Long time;

    public void setTime(Long time) {
        this.time = time;
    }
    public void doTag() throws JspException, IOException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            JspWriter out=getJspContext().getOut();
            out.print("报时:"+simpleDateFormat.format(new Date()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

