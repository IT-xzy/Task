package com.ptteng.utils;

import com.ptteng.pojo.exception.UnavailableException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /*long类型转换为String类型
    currentTime要转换的long类型的时间
    formatType要转换的string类型的时间格式*/
    public static String longToString(long currentTime, String formatType) {
        // long类型转成Date类型
        Date date = null;
        try {
            date = longToDate(currentTime, formatType);
        } catch (ParseException e) {
            UnavailableException e1 =  new UnavailableException("long转String类型失败");
            e1.initCause(e);
            throw e1;
        }
        // date类型转成String
        return dateToString(date, formatType);
    }

    /*string类型转换为date类型
    strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    HH时mm分ss秒，
    strTime的时间格式必须要与formatType的时间格式相同*/
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /*long转换为Date类型
    currentTime要转换的long类型的时间
    formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒*/
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        // 根据long类型的毫秒数生命一个date类型的时间
        Date dateOld = new Date(currentTime);
        // 把date类型的时间转换为string
        String sDateTime = dateToString(dateOld, formatType);
        // 把String类型转换为Date类型
        Date date = stringToDate(sDateTime, formatType);
        return date;
    }

    /*string类型转换为long类型
    strTime要转换的String类型的时间
    formatType时间格式
    strTime的时间格式和formatType的时间格式必须相同*/
    public static long stringToLong(String strTime, String formatType){
        // String类型转成date类型
        Date date = null;
        try {
            date = stringToDate(strTime, formatType);
        } catch (ParseException e) {
            UnavailableException e1 =  new UnavailableException("String转long类型失败");
            e1.initCause(e);
            throw e1;
        }

        if (date == null) {
            return 0;
        }

        // date类型转成long类型
        long currentTime = dateToLong(date);
        return currentTime;

    }

    /*date类型转换为long类型
    date要转换的date类型的时间*/
    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
