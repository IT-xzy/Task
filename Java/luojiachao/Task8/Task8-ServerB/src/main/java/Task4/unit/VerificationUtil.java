package Task4.unit;

import java.util.Random;

public class VerificationUtil {
    private static final String sources = "0123456789";

    /**
     * 生成6位随机数验证码
     * @return
     */
    public static String getVerificationCode(){
        StringBuilder sj = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++){
            sj.append(sources.charAt(random.nextInt(10)));
        }
        return sj.toString();
    }
}