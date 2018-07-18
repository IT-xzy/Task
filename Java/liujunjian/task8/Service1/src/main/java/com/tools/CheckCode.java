package com.tools;

import java.util.Random;

public class CheckCode {
    public static String generateCheckCode() { //生成开头不为0的6位随机验证码
        Random random = new Random();
        StringBuffer checkCode = new StringBuffer();
        //生成1-9的随机整数
        checkCode.append(random.nextInt(9) + 1);
        //循环添上5个0-9的随机整数
        for (int i = 1; i < 6; i++) {
            checkCode.append(random.nextInt(10));
        }
        //返回6位随机验证码
        return checkCode.toString();
    }
}
