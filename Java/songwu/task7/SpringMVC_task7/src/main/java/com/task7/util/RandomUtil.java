package com.task7.util;

import java.util.Random;

/**
 * Create by SongWu on 2018/8/4
 */
public class RandomUtil {

    public static String random(int key) {
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < key; i++) {
            sBuilder.append(random.nextInt(9)) ;
        }
       return sBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println( RandomUtil.random(6));
    }
}
