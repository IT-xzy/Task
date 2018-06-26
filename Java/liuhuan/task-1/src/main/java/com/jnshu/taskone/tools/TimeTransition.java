package com.jnshu.taskone.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTransition {
    /*  Long类型转换为String */
    public static String longToString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*  java.util.Date是毫秒单位 mysqlBigint是秒单位 */
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        /*  返回格式化时间戳字符串 */
        return simpleDateFormat.format(judt);
    }

    /*  date转换为long */
    public static Long dateTolong(java.util.Date judt){
        /*  date.getTime()所返回的是一个long型的毫秒数,除以1000得到秒  */
        return judt.getTime()/1000;
    }
}