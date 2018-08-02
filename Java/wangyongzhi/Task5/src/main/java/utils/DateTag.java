package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
    //为了验证版本一致性而设置的
    private static final long serialVersionUID = 6464168398214506236L;
    //此value属性用来接收jsp的传参
    private String value;

    private Logger logger = LogManager.getLogger(DateTag.class);

    @Override
    public int doStartTag() throws JspException {
        //将value转化为字符串形式
        String vv = "" + value;
        try {
            //设置想要设置的时间输出形式
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            long time = Long.valueOf(vv.trim());//trim去除字符串两端和中间的一些符号，包括空格
            Calendar c = Calendar.getInstance();//类的实例化
            c.setTimeInMillis(time);//用给定的 long 值设置此 Calendar 的当前时间值。

            //转化time为格式时间
            String s = dateformat.format(c.getTime());

            pageContext.getOut().write(s);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("时间转化错误");
        }
        return super.doStartTag();
    }
    //设置set方法接收value
    public void setValue(String value) {
        this.value = value;
    }

}
