package com.zyq.util;

public class RandomNumUtil {

    public static String registerMessage() {
        return String.valueOf((int) (Math.random() * 8999) + 1000);
    }
}
