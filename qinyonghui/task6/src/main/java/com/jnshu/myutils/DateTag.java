package com.jnshu.myutils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//TagSupport类这个类是IterationTag的实现类
public class DateTag extends TagSupport {
    /*
     * 其实序列化的作用是能转化成Byte流，然后又能反序列化成原始的类。能在网络进行传输，也可以保存在磁盘中，
     * 有了SUID之后，那么如果序列化的类已经保存了在本地中，中途你更改了类后，SUID变了，
     * 那么反序列化的时候就不会变成原始的类了，还会抛异常，主要就是用于版本控制。
     * 虽然还不知道到底有啥用
     * */
    private static final long serialVersionUID = 6464168398214506236L;
    private String value;
    //重写doStartTag方法，
    @Override
    public int doStartTag() throws JspException {
        //类型转化
        String str = "" + value;
        long time = Long.valueOf(str);
        /*
         *Calendar对日期进行操作的类，
         *getInstance方法返回一个Calendar对象（该对象为Calendar的子类对象），
         *其日历字段已由当前日期和时间初始化（输出当前时间）
         * */
        Calendar calendar = Calendar.getInstance();
        //java.util.Calendar.setTimeInMillis(long) 方法从给定的long值设置日历的当前时间
        calendar.setTimeInMillis(time);
        //定义日期格式
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str1 = dateformat.format(calendar.getTime());
        try {
            pageContext.getOut().write(str1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * doStartTag()方法是遇到标签开始时会呼叫的方法，
         * 其合法的返回值是EVAL_BODY_INCLUDE与SKIP_BODY,前者表示将显示标签间的文字，
         * 后者表示不显示标签间的文字
         * 默认SKIP_BODY，super的用法
         * */
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }
}