package com.student.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TimeTransition {
//    Long类型转换为String
    public static String longtoString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Java.util.Date 是毫秒单位 mysqlBigInt 是秒单位
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        return simpleDateFormat.format(judt);
    }

//    date转换为long
    public static Long dateToLong(java.util.Date judt){
//        date.getTime()所返回的是一个long型的毫秒数，除以1000得到秒
        return judt.getTime()/1000;
    }
}
