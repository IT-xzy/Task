package com.util;

import java.util.Random;

public class RandomNumAndChar {

    public static String getRandom(int n){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            //%取余，如果余数0，取"num"
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            //qualsIgnoreCase 忽略大小写
            if ("char".equalsIgnoreCase(str)) { // 产生字母
                //？？？？？？？
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) (nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(str)) { // 产生数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
