package com.jnshu.czm.tagl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag {

    public static  String dateTag(Long time,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date = new Date(time);
        String formatTime=simpleDateFormat.format(date);
        return formatTime;
    }
}