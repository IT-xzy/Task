package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class AuthCode {
    private static final int AUTHCODE_LENGTH =5; // 验证码长度
    private static final int SINGLECODE_WIDTH = 15; // 单个验证码宽度
    private static final int SINGLECODE_HEIGHT = 30; // 单个验证码高度
    private static final int SINGLECODE_GAP = 4; // 单个验证码之间间隔
    private static final int IMG_WIDTH = AUTHCODE_LENGTH * (SINGLECODE_WIDTH + SINGLECODE_GAP);
    private static final int IMG_HEIGHT = SINGLECODE_HEIGHT;
    private static final char[] CHARS = {'0','1', '2', '3', '4', '5', '6', '7', '8',
            '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static Random random = new Random();

    /**
     * 返回图片中的数字
     * @return String
     */
    public static String getAuthCode() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {// 生成6个字符
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 返回带数字的图片
     * @return BufferedImage
     */
    public static BufferedImage getAuthImg(String Code) {
        // 设置图片的高、宽、类型
        // RGB编码：red、green、blue
        BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
                BufferedImage.TYPE_INT_BGR);
        // 得到图片上的一个画笔
        Graphics g = img.getGraphics();
        // 设置画笔的颜色，用来做背景色
        g.setColor(Color.RED);
        // 用画笔来填充一个矩形，矩形的左上角坐标，宽，高
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        // 将画笔颜色设置为黑色，用来写字
        g.setColor(Color.BLACK);
        // 设置字体：宋体、不带格式的、字号
        g.setFont(new Font("宋体", Font.PLAIN, SINGLECODE_HEIGHT + 5));
        // 输出数字
        char c;
        for (int i = 0; i < Code.toCharArray().length; i++) {
            // 取到对应位置的字符
            c = Code.charAt(i);
            // 画出一个字符串：要画的内容，开始的位置，高度
            g.drawString(c + "", i * (SINGLECODE_WIDTH + SINGLECODE_GAP)
                    + SINGLECODE_GAP / 2, IMG_HEIGHT);
        }
        Random random = new Random();
        // 干扰素
        for (int i = 0; i < 15; i++) {
            int x = random.nextInt(IMG_WIDTH);
            int y = random.nextInt(IMG_HEIGHT);
            int x2 = random.nextInt(IMG_WIDTH);
            int y2 = random.nextInt(IMG_HEIGHT);
            g.drawLine(x, y, x + x2, y + y2);
        }
        return img;
    }
}
