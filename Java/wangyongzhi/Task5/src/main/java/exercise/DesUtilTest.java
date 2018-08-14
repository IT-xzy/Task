package exercise;

import desUtil.HfiveBase64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;


/**
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 * 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */

public class DesUtilTest {
    public DesUtilTest() {
    }
    public static String password = "9588028802489632";
    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "cryptologysdgdsfgdfbsdffsdgvxcvxdgfser";
//        //密码，长度要是8的倍数
//        String password = "9588028802489632";

        String result = DesUtilTest.encrypt(str);
        System.out.println("加密后："+ result);
        //直接将如上内容解密
        try {

            String decryResult = DesUtilTest.decrypt(result);
            System.out.println("解密后："+ decryResult);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param
     * @return byte[]
     */
    public static String encrypt(String datasource) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            byte[] encryptData = cipher.doFinal(datasource.getBytes()); //按单部分操作加密或解密数据，或者结束一个多部分操作
            return HfiveBase64.encode(encryptData);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param
     * @return byte[]
     * @throws Exception
     */

    //严重注意！！！！！
    //严重注意！！！！！
    //此处解密过程传入的参数必须是密文的字节数组！！！！也就是加密后直接得到的字节数组。不可用new String转
    //的字符串直接传入参数，然后方法中字符串再转字节的方式。会出错。估计是这一过程中会添加某些字节，导致解密失败。
    public static String decrypt(String src) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");//返回实现指定转换的 Cipher 对象
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        byte[] decryptData = cipher.doFinal(HfiveBase64.decode(src));
        return new String(decryptData);
    }



    //转化long为String
    public static String longFormString(long time) {
        String logintime = String.valueOf(time);
        return logintime;
    }

    //转化String为long
    public static long stringFormLong(String time) {
        long logintime = Long.parseLong(time);
        return logintime;
    }
}
