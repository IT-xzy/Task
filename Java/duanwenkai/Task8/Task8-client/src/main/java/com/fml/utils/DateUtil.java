package com.fml.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 将Date转化为想要的格式类型
     * @param date
     */
    public static String format(Date date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
