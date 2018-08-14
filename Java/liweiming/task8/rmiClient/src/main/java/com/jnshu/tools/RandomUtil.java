package com.jnshu.tools;

import java.util.Random;

/**
 * @program: task7
 * @description:
 * @author: Mr.Lee
 * @create: 2018-07-31 10:06
 **/
public class RandomUtil {
    private static final String sources = "0123456789";

    /**
     * 生成6位随机数验证码
     * @return
     */
    public static String getCode(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < 6; i++){
            sb.append(sources.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
