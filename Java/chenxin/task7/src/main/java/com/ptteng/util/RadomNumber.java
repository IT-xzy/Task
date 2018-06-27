package com.ptteng.util;

import java.util.Random;

public class RadomNumber {
    static Random random = new Random();
    public static int getNumber() throws Exception{
        return random.nextInt();
    }
}
