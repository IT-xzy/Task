package com.fangyuyang.subsidiary.validateCode;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

import com.fangyuyang.subsidiary.LoginInterceptor;
import javafx.geometry.Rectangle2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证码生成
 *
 * @author Administrator
 *
 */
public class ValidateCode {
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    Logger logger = LoggerFactory.getLogger(ValidateCode.class);
    // 生成的验证码
   private String validateCode = "";
    // 临时文件
    private File file;
    private Image image;
   private char[] value = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    //获取验证码图片，参数：n:验证码字符数量
    public Image getValidateCodeImage(int n) throws IOException {
        //验证码图片尺寸
        int width = 25 * n;
        int height = 30;

        Font font = new Font("黑体", Font.BOLD, 25);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setBackground(Color.WHITE);//背景色
        g2.clearRect(0, 0, width, height);
        g2.setFont(font);//字体

        String str = "";
        Random random = new Random();
        char[] c = new char[n];
        //绘制字符
        for (int i = 0; i < n; i++) {
            c[i] = value[random.nextInt(36)];
            g2.setColor(getRandColor(0, 255));
            g2.drawString(String.valueOf(c[i]), width / n * i, height -5);
        }
        str = String.valueOf(c);
        //绘制线条
        for (int i = 0; i < 10; i++) {
            g2.setPaint(getRandColor(0, 255));
            g2.drawLine(random.nextInt(width), random.nextInt(30), random.nextInt(width), random.nextInt(30));
            g2.drawPolygon(new Polygon());
        }
        //临时图片路径
        file = new File("E:\\JAVA_TEST\\task7_test3\\src\\main\\webapp\\pic\\" + str + ".jpeg");
        //输出到临时图像
        ImageIO.write(bi, "jpeg", file);
        this.validateCode = str;
        return image;
    }
    /**
     * 获取随机颜色
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    /**
     * 删除临时图片
     */
    public void destroy() {
        if (this.file.exists()) {
            this.file.delete();
        }
    }

    public String getValidateCode() {
        File files = new File("E:/JAVA_TEST/task7_test3/src/main/webapp/pic/");    //创建File对象,指向F盘根目录
        String[] names = files.list();    //获取F盘根目录所有文件和路径,并以字符串数组返回
         Random random = new Random();
         int n = random.nextInt(names.length);
         logger.info("原来validate,{}",validateCode);
         if(!names[n].equals(validateCode+".jpeg")){
             return names[n];
         }else {
             if(n==1)
             return names[n+1];
             if(n>2) return names[n-1];
         }

//        for (String s : names) {    //遍历字符串数组
//            if (s.equals(validateCode + ".jpeg")) return validateCode;
//
//        }
        return null;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}