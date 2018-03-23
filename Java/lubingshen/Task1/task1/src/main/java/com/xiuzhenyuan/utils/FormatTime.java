package com.xiuzhenyuan.utils;

public class FormatTime {
    public static String format(long milliseconds){
        long hour = milliseconds / (1000 * 60 * 60);
        long minute = (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        long second = ((milliseconds % (1000 * 60 * 60)) % (1000 * 60)) / 1000;
        return (hour + "时" + minute + "分" + second + "秒");
    }
}
