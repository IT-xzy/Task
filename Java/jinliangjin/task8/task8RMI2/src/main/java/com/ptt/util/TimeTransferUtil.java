package com.ptt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeTransferUtil
 * @Description: 时间转换
 * @Author: Jin
 * @CreateDate: 2018/6/12 10:07
 * @Version: 1.0
 */
public class TimeTransferUtil {
    /**
     * @Description: Date to String
     * @return: java.lang.String
     * @Date: 2018/6/12 10:14
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * @Description: String to Date.
     * @return: java.util.Date
     * @Date: 2018/6/12 10:15
     */
    public static Date string2Date(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return (Date) dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: Long to String
     * @return: java.lang.String
     * @Date: 2018/6/12 10:15
     */
    public static String long2String(long str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(str));
    }

    /**
     * @Description: long to date.
     * @return: java.util.Date
     * @Date: 2018/6/12 10:16
     */
    public static Date long2Date(Long str) {
        return new Date(str);
    }
}
