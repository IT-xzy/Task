package com.fgh.Mybatis.Tool;

        import java.text.SimpleDateFormat;
        import java.util.Date;

public class TimeReversal {
    private long myTime;

    public static String longtoString(long myTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        mysql的bigint是秒数,java.util.Date是毫秒,需先乘以1000再转换
        java.util.Date date = new Date(myTime * 1000);
        return sdf.format(date);
    }

    public static long Datetolong(Date date) {
        return date.getTime() / 1000;
    }

}


