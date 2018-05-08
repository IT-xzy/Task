package com.fml.utils;

import java.util.Random;

public class VerificationUtil {
    private static final String sources = "0123456789";

    /**
     * 生成6位随机数验证码
     * @return
     */
    public static String getVerificationCode(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < 6; i++){
            sb.append(sources.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
