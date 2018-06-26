package com.ptt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: TimeTranslateUtil
 * @Description: 时间转换。
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:36
 * @Version: 1.0
 */
public class TimeTranslateUtil {
    /**
     * @Description: Change Date to String.
     * @return: java.lang.String
     * @Date: 2018/5/3 18:50
     */
    public static String dateFormat(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * @Description: Change String to Date.
     * @return: java.util.Date
     * @Date: 2018/5/3 18:51
     */
    public static Date StringToDate(String str) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = (Date) formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description: 将CST时间类型字符串进行格式化输出。
     * @return: java.lang.String
     * @Date: 2018/5/3 18:54
     */
    public static String CSTFormat(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = null;
        try {
            date = (Date) formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat(date);

    }

    /**
     * @Description: 将Long转化为Date形式的String。
     * @return: java.util.Date
     * @Date: 2018/5/3 18:52
     */
    public static String LongToString(long str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(str));
    }

    /**
     * @Description: Long to Date.
     * @return: java.util.Date
     * @Date: 2018/5/3 19:13
     */
    public static Date LongToDate(Long str) {
        return new Date(str);
    }
}
