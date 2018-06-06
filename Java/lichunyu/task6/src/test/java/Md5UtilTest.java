import org.junit.Test;
import utils.Md5Util;

/**
 * 加盐MD5测试
 */
public class Md5UtilTest {
    @Test
    public void md5Test(){
        String pwd="abc123";
        System.out.println("原始数据："+pwd);

        System.out.println("普通MD5："+Md5Util.createMd5(pwd));
        System.out.println("加盐MD5:"+Md5Util.createSaltMd5(pwd));
        System.out.println("是否是同一字符串："+Md5Util.verifySaltMd5(pwd,Md5Util.createSaltMd5(pwd)));
    }

}
