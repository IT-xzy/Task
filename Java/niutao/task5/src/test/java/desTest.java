
import com.util.DES;
import com.util.MD5;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class desTest {

    @Test
    public void gogoDES() throws UnsupportedEncodingException {
        //待加密内容
        String str = "1"+"20:42:11";
        //密码，长度要是8的倍数
        String password = "abcdefga";
        byte[] result = DES.encrypt(str.getBytes(), password);
        System.out.println("加密后：" + new String(Base64.encodeBase64(result)));

        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后：" + new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void gogoMD5(){
        String str = "niutao";
        String out = MD5.getMD5(str);
        System.out.println("md5加密后的数据"+out);
        System.out.println(out.length());
    }

}
