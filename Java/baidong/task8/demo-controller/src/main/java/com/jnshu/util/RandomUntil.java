package com.jnshu.util;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomUntil {
    public static  int random() {
        Random random = new Random();
        int a = random.nextInt(2);
        return a;
    }
}
