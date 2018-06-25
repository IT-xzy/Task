import org.junit.Test;
import pojo.User;
import utils.DesUtil;
import utils.Md5Util;
import utils.Sha256Util;
import utils.StrConvertUtil;

/**
 * 测试DES加密工具类
 */
public class DesUtilTest {
    @Test
    public void DesTest() throws Exception {
        String encode = "需要加密的内容Aa1+/.-";
        Long nowMillis = System.currentTimeMillis();
        byte[] primaryData = encode.getBytes(); //初始的加密的内容转换成字节数组

        String s = StrConvertUtil.byteArrToHexStr(primaryData); //byte数组转换成16进制的字符串
        byte[] b = StrConvertUtil.hexStrToByteArr(s); //16进制的字符串转换成byte数组
        String bt = new String(b);

        User user = new User();
        user.setId("1");

        String str = user.getId()+":"+System.currentTimeMillis();
        String encryptedData = DesUtil.encrypt(str);//des加密
        String enNow = DesUtil.encrypt(String.valueOf(nowMillis));

        String decryptedData = DesUtil.decrypt(encryptedData);//des解密
        String[] plit = decryptedData.split("\\:");
        String id = plit[0];
        String time = plit[1];
        String deNow = DesUtil.decrypt(enNow);

        String MdStr = Md5Util.createMd5(encode); //MD5加密后的字符串
        String Sha256Str = Sha256Util.createSha256("123456"); //SHA256加密后的字符串

        System.out.println("byte转换16进制的字符串：" + s+ ",长度：" + s.length());
        System.out.println("16进制转换成byte数组：" + bt+ ",长度：" + bt.length());
        System.out.println("DES加密前的字符串：" + encode + ",长度：" + encode.length());
        System.out.println("DES加密后的字符串：" + encryptedData + ",长度：" + encryptedData.length());
        System.out.println("DES加密后的字符串：" + enNow +"="+nowMillis+ ",长度：" + enNow.length());
        System.out.println("DES解密后的字符串：" + id + ",长度：" +time);
        System.out.println("DES解密后的字符串：" + deNow + ",长度：" + deNow.length());
        System.out.println("MD5加密后的字符串：" + MdStr + ",长度：" + MdStr.length());
        System.out.println("SHA256加密后的字符串：" + Sha256Str + ",长度：" + Sha256Str.length());

    }
}

