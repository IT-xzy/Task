package yxpTask6.util.loginUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;

/*
MD5加盐工具类
*/
@Component
public class Md5Salt
{
    Logger logger=Logger.getLogger(Md5Salt.class);
    //加密算法，传入待加密的字符，和盐值；
    public String encrypt(String string,String salt)
    {
        String stringEncrypt=null;
        //如果账号或密码为空，返回error；
        if(string!=null&&salt!=null)
        {
            try {
                //声明使用md5加密
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //得到初始的md5加密字符串
                byte b1[] = string.getBytes();
                byte b2[] = messageDigest.digest(b1);
                String string1 = new BigInteger(1, b2).toString(16);
                //进行md5加盐加密
                String stringFinal = string1 + salt;
                byte final1[] = stringFinal.getBytes();
                byte final2[] = messageDigest.digest(final1);
                String stringFinal2 = new BigInteger(1, final2).toString(16);
                stringEncrypt = stringFinal2;
            } catch (Exception e) {
                logger.error("加密出现错误。。");
                e.printStackTrace();
            }
            //返回加密后的值；
            return stringEncrypt;
        }
        //传入出现空值，直接返回null；
        return stringEncrypt;

    }

    //解密算法
    public Boolean decrypt (String stringPass,String salt,String stringEncrypt)
    {
        boolean booleanDecrypt=false;
        String stringDecrypt=null;
        //传入的值不为空，进行验证
        if (stringPass!=null&&salt!=null&&stringEncrypt!=null)
        {
            try {
                //声明使用md5加密
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //得到初始的md5加密字符串
                byte b1[] = stringPass.getBytes();
                byte b2[] = messageDigest.digest(b1);
                String string1 = new BigInteger(1, b2).toString(16);
                //进行md5加盐加密
                String stringFinal = string1 + salt;
                byte final1[] = stringFinal.getBytes();
                byte final2[] = messageDigest.digest(final1);
                String stringFinal2 = new BigInteger(1, final2).toString(16);
                stringDecrypt = stringFinal2;
                //进行加密后密码的判断
                if (stringDecrypt.equals(stringEncrypt)) {
                    booleanDecrypt = true;
                } else {
                    booleanDecrypt = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return booleanDecrypt;
        }
        //传入出现空值，返回false的boolean值；
        return booleanDecrypt;
    }

}
