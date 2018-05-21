package jnshu.tasksix.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * 完成对传入参数的DES算法的加密和解密
 *
 * @author Administrator
 * @date 2017-10-01
 */


public class DesUtils {

    private static Logger loggerDES = LoggerFactory.getLogger(DesUtils.class);
    //加密
    public byte[] desCrypto(byte[] datasource,String password){

        try{
            //生成一个强随机的数
            SecureRandom random = new SecureRandom(password.getBytes());
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey  = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
            loggerDES.error("e.getMessage()： " + e.getMessage());
        }
        return null;
    }

    //解密
    public byte[] decrypt(byte[] src, String password) throws Exception{

        //DES算法要有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        //创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        //创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        //将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey  = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE,securekey, random);
        //真正开始解密
        return cipher.doFinal(src);
    }
}
