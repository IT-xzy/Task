package com.ptteng.utils;




import java.util.Random;

/**
 * @ClassName RandomUtil
 * @Description
 * 生成随机数,随机数如果为 0 或 1 ,根据随机数的不同,
 * 调用不同的bean.而不同的bean对应server不同的服务
 * @Author 孙若飞
 * @Date 2019/3/23  9:22
 * @Version 1.0
 **/
public class RandomUtil {

    public static int randomCode() {
        return new Random().nextInt(2);

    }
}


