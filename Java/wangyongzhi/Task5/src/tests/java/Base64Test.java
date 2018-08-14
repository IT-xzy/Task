import exercise.Base64UtilTest;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    @Test
    public void test() {
//        String word = "星空蓝色";
//        word = Base64UtilTest.encoder(word);
//        System.out.println(word);
//        System.out.println(Base64UtilTest.decoder(word));
    }

    @Test
    public void testGetBytes(){
        try {
            byte[] b_gbk = "深".getBytes("GBK");
            byte[] b_utf8 = "深".getBytes("UTF-8");
            byte[] b_iso88591 = "深".getBytes("ISO8859-1");
            byte[] b_unicode = "深".getBytes("unicode");
            System.out.println(new String(b_gbk, "GBK"));
            System.out.println(new String(b_gbk, "UTF-8"));
            System.out.println(new String(b_utf8, "UTF-8"));
            System.out.println(new String(b_iso88591, "ISO8859-1"));
            System.out.println(new String(b_unicode, "unicode"));
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
