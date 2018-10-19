package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * Date形式日期转换成标准日期 String --> Date "yyyy-MM-dd HH:mm:ss"-->yyyy-MM-dd HH:mm:ss
     */
    public static String getTheYear(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }
    public static String dateToYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String dateToYMDHMS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String dateToYMDhms(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        return sdf.format(date);
    }

    /**
     * 字符串形式日期转换成标准日期 String --> Date "yyyy-MM-dd"-->yyyy-MM-dd
     */
    public static Date YMDToDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串形式日期转换成标准日期 String --> Date "yyyy-MM-dd HH:mm:ss"-->yyyy-MM-dd HH:mm:ss
     */
    public static Date YMDHMSToDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
