package jnshu.util;
import org.junit.Test;


public class RandomCode {

    public static String createCode()throws Exception{
        String code="";
        for (int  = ;  < ; ++) {
            int temp=((int) (Math.;
            code+=temp;
        }
        return code;
    }

    @Test
    public void test()throws Exception{
        System.out.println(RandomCode.createCode());
    }
}
