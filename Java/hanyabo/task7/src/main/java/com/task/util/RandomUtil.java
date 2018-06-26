package com.task.util;

public class RandomUtil {

    public static String getCode(){
        int iCode = (int)((Math.random()*9+1)*100000);
        String code = ""+iCode;
        return code;
    }
}
