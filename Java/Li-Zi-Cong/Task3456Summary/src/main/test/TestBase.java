import jnshu.util.DES;
import org.junit.Test;

import javax.servlet.http.Cookie;
import java.util.Date;

public class TestBase {

//    时间戳
//    @Test
//    public  void getToken()throws Exception{
//        String input = "eee222";
//        String salt = "QWERASDF";
////        生成时间戳
//        Long timeStamp = System.currentTimeMillis() / 1000;
//
////        拼装待加密数据
//        String date = input+"/"+salt+"/"+timeStamp;
//
////        加密
//        String bytes2=DES.desEncodeCBC("qwerasdf",date);
//
////        解密
//        System.out.println(DES.desDecodeCBC("qwerasdf",bytes2));
//    }

    @Test
    public void testString(){
        String date = "qqq"+"/"+"1qw2"+"/"+"259201";
        String[] temp =date.split("/",0);
        System.out.println(temp[2]);
        long nowTimeStamp = System.currentTimeMillis()/1000;
        System.out.println("n:"+nowTimeStamp);
        long legalTime = 3600*24*3;
        System.out.println("l:"+legalTime);
        System.out.println("yun::"+(Long.valueOf(temp[2])-legalTime));


    }

}
