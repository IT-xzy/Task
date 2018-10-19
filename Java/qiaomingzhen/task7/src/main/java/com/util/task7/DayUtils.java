package com.util.task7;
/*
 * @ClassName:DayUtils
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/7 21:04
 **/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DayUtils {
    private static final int YESTERDY = -1;
    private static final int TODAY = 0;
    private static final int TOMORROWDAT = 1;
    private static final int OTHER_DAY = 10000;

    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();

    /**
     * 读取日期的格式
     */
    public static SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA));
        }
        return DateLocal.get();
    }

    /**
     * 调用显示日期
     */
    public static String getTitleDay(String day) {
        try {
            /*
            boolean isToday;
            boolean isYesterday;
            boolean isTomorrowday;
            isToday = IsToday(day);
            isYesterday = IsYesterday(day);
            isTomorrowday = IsTomorrowday(day);
            if(isToday){
                return "今天";
            }else if(isYesterday){
                return "昨天";
            }else if(isTomorrowday){
                return "明天";
            }else{
                return day;
            }*/
            switch (JudgmentDay(day)) {
                case YESTERDY: {
                    return "今天";
                }
                case TODAY: {
                    return "昨天";
                }
                case TOMORROWDAT: {
                    return "明天";
                }
                default:
                    return day;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断日期(效率比较高)
     */
    public static int JudgmentDay(String day) throws ParseException {
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            switch (diffDay) {
                case YESTERDY: {
                    return YESTERDY;
                }
                case TODAY: {
                    return TODAY;
                }
                case TOMORROWDAT: {
                    return TOMORROWDAT;
                }
            }
        }
        return OTHER_DAY;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true昨天 false不是
     * @throws ParseException
     */
    public static boolean IsYesterday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == YESTERDY) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsToday(long day){
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = new Date(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == TODAY) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为明天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true明天 false不是
     * @throws ParseException
     */
    public static boolean IsTomorrowday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == TOMORROWDAT) {
                return true;
            }
        }
        return false;
    }

}
