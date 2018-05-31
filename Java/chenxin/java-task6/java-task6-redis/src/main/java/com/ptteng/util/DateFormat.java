package com.ptteng.util;

import java.text.SimpleDateFormat;

public class DateFormat {
    public String getFormateTime(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateString= simpleDateFormat.format(time);
        return dateString;
    }
}
