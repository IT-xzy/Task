package com.DateTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {
// 读取

    //private static final long serialVersionUID = 6464168398214506236L;
    private String value;

    @Override
    public int doStartTag() throws JspException {
        if (!value.equals("")) {
            String vv = "" + value;
            try {
                //将字符串转换为long, trim()除去空格,转换时不能有空格
                long timeLong = Long.valueOf(vv.trim());
                System.out.println(timeLong);
                //将数据库里取到的 时间戳转为 Data格式     例如：Sat May 05 05:05:05 CST 2018
                java.util.Date judt = new Date(timeLong * 1000);
                System.out.println(judt);

                //创建 设置时间格式的 的对象
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //将Data 格式 转换为自己设置的 时间格式   例如: 2018-05-05 05:05:05
                String s = simpleDateFormat.format(judt);
                System.out.println(s);

                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {
            /* 为空时返回空值,不处理 jsp会解析出错*/
            String s = "";
            try {
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return super.doStartTag();
    }

    //传入的时间格式String
    public void setValue(String value) {
        this.value = value;
    }
        }