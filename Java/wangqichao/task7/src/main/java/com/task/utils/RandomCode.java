package com.task.utils;

public class RandomCode {
    /**
     * 获取指定长度的随机数
     * @param length 随机数的长度
     * @return String
     */
    public static String getRandom(int length){
        String random="";
        for(int i=0;i<length;i++) {
            int a = (int) (Math.random() * 10);
            random=random+a;
        }
        return random;
    }
}
