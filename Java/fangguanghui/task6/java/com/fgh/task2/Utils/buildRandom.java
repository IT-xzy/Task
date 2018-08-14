package com.fgh.task2.Utils;

public class buildRandom {

    public static String Random(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        int i_random=(int) ((random * num));
        String s_random=String.valueOf(i_random);
        return s_random;
    }
}
