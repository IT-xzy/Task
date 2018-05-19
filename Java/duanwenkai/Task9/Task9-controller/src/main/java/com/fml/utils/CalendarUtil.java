package com.fml.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    public static Date getDailyStartTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
