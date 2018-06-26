package utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Date转化工具
 * 把Long类型转化成可读性时间
 */
public class DateTag extends TagSupport {
    private static final long serialVersionUID=6464168398214506236L;
    private String value;

    @Override
    public int doStartTag() throws JspException{
        String vv = ""+value;
        Long time = Long.valueOf(vv); //将vv转化成Long类型
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time); //将Long转换成时间类型
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateFormat.format(c.getTime()); //格式化时间为String类型

        try{
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value){
        this.value = value;
    }
}
