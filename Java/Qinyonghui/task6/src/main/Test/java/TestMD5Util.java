import org.junit.Test;

import static com.jnshu.myutils.PasswordUtil.generate;
import static com.jnshu.myutils.PasswordUtil.verify;


public class TestMD5Util {
    @Test
     public void   testMD5Util(){
       //加密+加盐
       String password1 = generate("admin");
        System.out.println("结果：" + password1 + "   长度："+ password1.length());
        // 解码
        System.out.println(verify("admin", password1));

        // 加密+加盐
        String password2= generate("admin");
        System.out.println("结果：" + password2 + "   长度："+ password2.length());
        // 解码
        System.out.println(verify("admin", password2));
    }
}
