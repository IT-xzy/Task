package hzw.model;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间转换
 */
public class LongToDate extends TagSupport {
    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long serialVersionUID = 6464168398214506236L;
    private String value;
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try{
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String s = dateFormat.format(c.getTime());
            pageContext.getOut().write(s);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}
