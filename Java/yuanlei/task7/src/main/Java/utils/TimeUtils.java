package utils;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import java.util.Date;

public class TimeUtils extends TagSupport{

    private  Long  value;

    public void setValue(Long value){
        this.value = value;
    }
    @Override
    // 覆盖TagSupport类的doStartTag方法
     // 当遇到标签（也就是<date:date>）的开始标记时调用该方法
    public int doStartTag() throws JspException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value==null) {
            //调用date的无参构造方法新建对象并引用,作用是获取当前系统的时间(Date类型的时间戳)
            Date date = new Date();

            //将Date类型的时间戳格式化为指定格式的时间字符串
            String string = simpleDateFormat.format(date);
            try {
                //浏览器中输出已格式化好的当前系统时间字符串
                pageContext.getOut().print(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Date date = new Date(value);
            String string = simpleDateFormat.format(date);
            try {
                pageContext.getOut().print(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // TagSupport类的doStartTag方法默认返回SKIP_BODY，表示忽略自定义标签体
        return super.doStartTag();
    }
}
