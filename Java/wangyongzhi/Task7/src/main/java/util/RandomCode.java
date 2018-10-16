package util;

import java.util.Random;
/**
 * @Description: 生成6位随机验证码工具类
 */
public class RandomCode {
    public static String getSixRandom() {
        Random random = new Random();
        //生成0到1000000之间随机数
        String sixRandom = random.nextInt(1000000) + "";
        int randLength = sixRandom.length();
        //如果位数小于6的处理办法
        if (randLength < 6) {
            for(int i =1; i <= 6 - randLength; i++){
                sixRandom = "0" + sixRandom;
            }
        }
        return sixRandom;
    }
}
