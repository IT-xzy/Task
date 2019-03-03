package com.jnshu.task7.utils;

import java.text.SimpleDateFormat;

public class TimeUtil {
    public static String newTime(){
        //转换时间戳
        Long  time = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String newTime = simpleDateFormat.format(time);
        return newTime;
    }


}
