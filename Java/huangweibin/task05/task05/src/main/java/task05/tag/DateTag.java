package task05.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 用于页面 jstl时间格式化
 */
public class DateTag extends TagSupport {

    private static final long serialVersionUID  = 6464168398214506236L;

//    定义一个变量
    private String value;

//    定义一个方法
    public int doStartTag() throws JspException {

//        定义了一个指向 value 的变量
        String vv = "" + value;

//        将 String 类型转换成 long 型
        Long time = Long.valueOf(vv);

//        定义有一个时间类型
        Calendar c = Calendar.getInstance();

//        setTimeInMillis 方法从给定的 long 值设置日历的当前时间
        c.setTimeInMillis(time);

//        SimpleDateFormat 设置出一个时间格式
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        将要格式化为时间字符串的时间值设为日期。
        String s = dateformat.format(c.getTime());

//        定义一个"yyyy-MM-dd HH:mm:ss"格式的时间
        try {

            pageContext.getOut().write(s);

        } catch (IOException e) {

            e.printStackTrace();
        }
        return super.doStartTag();
    }

        public void setValue(String value) {
            this.value = value;
        }
    }

