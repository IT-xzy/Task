package com.jnshu.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 自定义 JSP 标签 将long类型时间数据转换为string类型的时间格式数据*/
public class JspTag extends TagSupport {
    //jsp传过来的是字符串类型的
    private String value;
    private static Logger logger = LoggerFactory.getLogger(JspTag.class);

    @Override
    public int doStartTag() throws JspException {
        if (!value.trim().isEmpty()) {
            String vv = "" + value;
            try {
                // logger.debug("vv: " + vv);
                //将字符串转换为long, trim()除去空格,转换时不能有空格
                long timeLong = Long.valueOf(vv.trim());
                // logger.debug("Long 开始转换为 String : " + timeLong);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date judt = new Date(timeLong);
                String s = simpleDateFormat.format(judt);
                pageContext.getOut().write(s);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("转换失败");
            }
        } else {
            logger.debug("vv test");
            /* 为空时返回空值,不处理 jsp会解析出错*/
            String s = "";
            try {
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error("Time Is NULL!");
        }
        return super.doStartTag();
    }

    //传入的时间格式String
    public void setValue(String value) {
        this.value = value;
    }
}