package com.ptteng;

import com.ptteng.util.DateFormat;
import org.junit.Test;

public class DateFormatTest {
    @Test
    public void timeFormat(){
        DateFormat dateFormat = new DateFormat();
        String s=dateFormat.getFormateTime(System.currentTimeMillis());
        System.out.println(s);
    }
}
