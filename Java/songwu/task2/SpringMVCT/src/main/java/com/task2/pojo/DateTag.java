package com.task2.pojo;

import javax.servlet.jsp.tagext.TagSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {
    private static final long serialVersionUID = -5743295339374288539L;

    private long sjc;// 时间戳(输入)

    private String dTime;// 日期时间(输出)

    private String patten;// 日期格式

    /**
     * 时间戳转换成日期时间
     *
     * @return
     */
    public int doStartTag() {
        try {
            String timeStr = sjc + "000";
            long timeL = Long.parseLong(timeStr);
            Date timeDate = new Date(timeL);
            SimpleDateFormat sdf = new SimpleDateFormat(patten);
            dTime = sdf.format(timeDate);
            pageContext.getOut().println(dTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }



    public long getSjc() {
        return sjc;
    }



    public void setSjc(long sjc) {
        this.sjc = sjc;
    }



    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getPatten() {
        return patten;
    }

    public void setPatten(String patten) {
        this.patten = patten;
    }


}

