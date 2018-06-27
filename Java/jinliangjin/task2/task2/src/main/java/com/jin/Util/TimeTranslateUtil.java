package com.jin.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ProjectName: task2
 * @Package: com.jin.Util
 * @ClassName: TimeTranslateUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/9 14:49
 * @UpdateUser:
 * @UpdateDate: 2018/5/9 14:49
 * @UpdateRemark:
 * @Version: 1.0
 */
public class TimeTranslateUtil {
    /**
     * @Description: Change Date to String.
     * 〈〉
     * * @param date
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/3 18:50
     */
    public static String dateFormat(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * @Description: Change String to Date.
     * 〈〉
     * * @param str
     * @return: java.util.Date
     * @since: 1.0.0
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
     * 〈〉
     * * @param str
     * @return: java.lang.String
     * @since: 1.0.0
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
     * 〈〉
     * * @param str
     * @return: java.util.Date
     * @since: 1.0.0
     * @Date: 2018/5/3 18:52
     */
    public static String LongToString(long str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(str));
    }

    /**
     * @Description: Long to Date.
     * 〈〉
     * * @param str
     * @return: java.util.Date
     * @since: 1.0.0
     * @Date: 2018/5/3 19:13
     */
    public static Date LongToDate(Long str) {
        return new Date(str * 1000);
    }
}
