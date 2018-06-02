package service;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDate {

    static Logger logger = Logger.getLogger(TimeDate.class.getName());

    //    时间相关测试
    @Test
    public void testDate() throws InterruptedException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long start = System.currentTimeMillis();

        Calendar calendar = Calendar.getInstance();
        //获取系统当前年份
        int year=calendar.get(Calendar.YEAR);
        //获取系统当前月份
        int month = calendar.get(Calendar.MONTH) + 1;
        //获取系统当然日期
        int day = calendar.get(Calendar.DATE);
        //获取系统当前小时
        int hour = calendar.get(Calendar.HOUR);
        //获取系统当然分钟
        int minute = calendar.get(Calendar.MINUTE);
        //获取系统当前秒数
        int second = calendar.get(Calendar.SECOND);

//        获取毫秒数的时间戳 13位
        System.out.print("\n" + date.getTime() + "\n");
//        获取当前时间
        System.out.print("\n" + df.format(date) + "\n");
//        转化时间戳
        System.out.print("\n" + df.format(date.getTime()) + "\n");

        Date now = new Date();
        long strNow = now.getTime();
        long strSystem =  System.currentTimeMillis();
        SimpleDateFormat stm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.print(strNow + "\n");
        System.out.print(strSystem + "\n");

        String str1 = stm.format(now);
        String str2 = stm.format(strNow);

        System.out.print( now + "\n");
        System.out.print( str1 + "\n");
        System.out.print( str2 + "\n");

        long end = System.currentTimeMillis();
        long time = (end-start);
        logger.info(time);
        logger.info("\n程序运行时间： "+ formatDuring(time) + "\n");

    }

    public static String formatDuring(long mss) throws InterruptedException {

        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;

//                TimeUnit.DAYS.sleep(1);//天
//                TimeUnit.HOURS.sleep(1);//小时
//                TimeUnit.MINUTES.sleep(1);//分
//                TimeUnit.SECONDS.sleep(1);//秒
//                TimeUnit.MILLISECONDS.sleep(1000);//毫秒
//                TimeUnit.MICROSECONDS.sleep(1000);//微妙
//                TimeUnit.NANOSECONDS.sleep(1000);//纳秒

        String time = "";
        if(days != 0){
            time += days+"天";
        }
        if(hours != 0){
            time += hours+"小时";
        }
        if(minutes != 0){
            time += minutes+"分钟";
        }
        if(seconds != 0){
            time += seconds+"秒\n";
        }
        if(days == 0 & hours == 0 &minutes == 0 & seconds == 0){
            time += String.valueOf(mss) + "毫秒";
        }
        return time;
    }

}
