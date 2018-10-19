package jnshu.util;
import org.junit.Test;


public class RandomCode {

    public static String createCode()throws Exception{
        String code="";
        for (int i = 0; i < 4; i++) {
            int temp=((int) (Math.random() * 9));
            code+=temp;
        }
        return code;
    }

    @Test
    public void test()throws Exception{
        System.out.println(RandomCode.createCode());
    }
}
