package com.jnshu.utils;
import java.util.Random;

public class RandomHan {
    private final static int delta = 0x9fa5 - 0x4e00 + 1;

    //随机生成汉字
    public static char getRandomHan() {
        Random ran = new Random();
        return (char) (0x4e00 + ran.nextInt(delta));
    }
}
