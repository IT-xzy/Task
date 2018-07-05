package com.ptteng;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaTest {
    /**
     * 目标生成四位随机字符串
     * 验证码里面可以有符号吗？
     */

    //用于生成随机数的对象
    private static Random random = new Random();
    //生成验证码所需要使用的字符
    private static char[] captchaChars =
            ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefg" +
             "hijklmnopqrstuvwxyz0123456789").toCharArray();
    //生成的验证码所需要的字符数量
    private static final int NUMBER_OF_CAPTCHA = 4;
    //验证码图片宽度和高度
    private static final int IMG_WIDTH = 65;
    private static final int IMG_HEIGHT = 26;

    @Test
    public void getCaptchaTest(){
        /**
         * 实例化BufferdImage，BufferedImage通过可修改的图像数据的缓冲区来描述image。
         * BufferdImage由ColorMode和Raster(光栅图或位图)组成。
         */
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();

        //用于保存验证码字符串
        StringBuffer stringBuffer = new StringBuffer();
        //数组下标
        int index;
        for (int i=0;i< NUMBER_OF_CAPTCHA; i++){
            //生成随机下标
            index = random.nextInt(captchaChars.length);
            stringBuffer.append(captchaChars[index]);
        }
        System.out.println("随机生成的字符串："+stringBuffer);
    }
}
