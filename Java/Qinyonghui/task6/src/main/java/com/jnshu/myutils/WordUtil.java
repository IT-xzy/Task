package com.jnshu.myutils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class WordUtil {
    //随机生成常见汉字
    public static String getRandomChar() {
        String str = "";
        int highCode;
        int lowCode;

        Random random = new Random();

        highCode = (176 + Math.abs(random.nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
        lowCode = (161 + Math.abs(random.nextInt(93))); //A1 + 0~93 每区有94个汉字

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

      public static String  creatWord(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str = getRandomChar();
        }
        return str;
    }

  /*  public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = getRandomChar();
            System.out.print(str + " ");
        }
    }*/
}
