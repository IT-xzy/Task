package yxpTask6.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

@Component
public class JavaDES
{
    /*java des加密工具类
    1.这个工具类使用的是固定的加密密钥；
    2.密钥都是固定字符，不进行随机或别的数据；
    * */
    //加密方法
    public String encryptDes(String password)
    {
        //密钥
        String key="keyabcdefghijklmnopqrstovwxyz";
        String passwordEncrypt=null;
        //字符转换；
        byte[] DESKey =key.getBytes();
        byte[] passwordByte =password.getBytes();
        byte[] DESPassword =null;
        try
        {
            //得到受信任的随机源，后面参数使用；
            SecureRandom secureRandom=new SecureRandom();
            //用字符串，生成密钥
            DESKeySpec desKey = new DESKeySpec(DESKey);
            //密钥工厂进行实例化des
            SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DES");
            //得到scretKey,
            SecretKey secretKey=secretKeyFactory.generateSecret(desKey);
            //得到des加密对象
            Cipher cipher = Cipher.getInstance("DES");
            //初始化des加密对象
            cipher.init(Cipher.ENCRYPT_MODE,secretKey,secureRandom);
            //使用密码作为参数进行运算生成密码
            DESPassword=cipher.doFinal(passwordByte);
            //输出密码，未指定密码形式会变成乱码
//            String str111=new String(DESPassword);
//            System.out.println("加密后密码(乱码形式)为："+str111);
            //使用sun.misc.BASE64Encoder().encode方法可以将密码进行转换成正常字符；
            String str222=new BASE64Encoder().encode(DESPassword);
//            System.out.println("加密后密码(正常形式)为："+str222);
            passwordEncrypt=str222;
        }
        catch (Throwable e) {
            e.printStackTrace();
        }

        return passwordEncrypt;
    }


    //解密方法
    public String decryptDes(String decrypt)
    {
        String key="keyabcdefghijklmnopqrstovwxyz";
        String passwordEncrypt=null;
        byte[] passwordByte0=null;
        byte[] DESKEY2=key.getBytes();
        byte[] passwordByte2 =null;
        try
        {
            //得到受信任的随机源，后面使用；
            SecureRandom secureRandom2=new SecureRandom();
            //用字符串，生成密钥
            DESKeySpec desKey2 = new DESKeySpec(DESKEY2);
            //密钥工厂进行实例化des
            SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DES");
            //得到scretKey,
            SecretKey secretKey=secretKeyFactory.generateSecret(desKey2);
            //得到des加密对象
            Cipher cipher = Cipher.getInstance("DES");
            //初始化des解密对象
            cipher.init(Cipher.DECRYPT_MODE,secretKey,secureRandom2);
            //使用方法进行解密
            //byte DESPassword2 []=cipher.doFinal(passwordByte2);
            //stringFF=new String(DESPassword2);
            //stringFF=new sun.misc.BASE64Encoder().decode(DESPassword2);
            //System.out.println("解密后密码为 ："+new String(DESPassword2));
            //System.out.println("解密后的密码为:"+stringFF);
            //输出密码
            //base64编码的密码字节数组；
            passwordByte2=new BASE64Decoder().decodeBuffer(decrypt);
            //取得正常编码的密码；
            passwordByte0=cipher.doFinal(passwordByte2);
            //将字节数组转换为字符串；
            passwordEncrypt=new String(passwordByte0);
//            System.out.println("解密后的密码为："+passwordEncrypt);

        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return passwordEncrypt;
    }
}
