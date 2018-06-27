package com.ptteng.captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class CaptchaUnit {
    //定义图片的width和height,以及图片上数字的数目
    private static final int WIDTH=90;
    private static final int HEIGHT=20;
    private static final int codeCount=4;

    private static int xx = 15;
    private static int fontHeight = 18;
    private static int codeY = 16;
    private static char[] codeSequence =
            ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefg" +
                    "hijklmnopqrstuvwxyz0123456789").toCharArray();

    /**
     * 生成一个map集合
     * code为生成的验证码
     * codePic为生成的图片验证码的BufferedImage对象
     * @ruturn
     */
    public static Map<String, Object> generateCodeAndPic(){
        //定义图像buffer
        BufferedImage buffImg = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
//        Graphics2D gd = buffImg.createGraphics();
//        Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        //创建随机数生成器对象
        Random random = new Random();
        //将图像填充为白色
        gd.setColor(Color.white);
        gd.fillRect(0, 0, WIDTH, HEIGHT);

        //创建字体，字体的大小应该根据图片的大小来定
        Font font = new Font("Fixedsys",Font.BOLD,fontHeight);
        //设置字体
        gd.setFont(font);

        //画边框
        gd.setColor(Color.black);
        gd.drawRect(0,0 ,WIDTH-1 ,HEIGHT-1 );

        //随机生成40条干扰线，使图像中的验证码不易被其他程序探测到。
        gd.setColor(Color.black);
        for (int i=0;i<30;i++){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            gd.drawLine(0,0 , x+x1, y+y1);
        }

        //randomCode用于保存随机生成的验证码，以便用户登录后验证
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        Map<String,Object> map  =new HashMap<String,Object>();
        //存放验证码
        map.put("code", randomCode);
        //存放生成的验证码BufferedImage对象
        map.put("codePic", buffImg);
        return map;
    }

}
