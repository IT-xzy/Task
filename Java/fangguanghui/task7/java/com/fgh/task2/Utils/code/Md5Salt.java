package com.fgh.task2.Utils.code;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Md5Salt {
    private static final String HEX_NUMS_STR="0123456789ABCDEF";
    private final static Integer SALT_LENGTH = 12;
    private static Logger logger=LogManager.getLogger(Md5Salt.class);

    /**
     * 将16进制字符串转换成字节数组
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex){
        int len=(hex.length()/2);
        byte[] result=new byte[len];
        char[] hexChars=hex.toCharArray();
        for (int i=0;i<len;i++){
            int pos=i*2;
            result[i]=(byte)(HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 |
                    HEX_NUMS_STR.indexOf(hexChars[pos+1]));
        }
        return result;
    }



    /**
     * MD5加密后
     * @param passwd  明文
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEncryptPwd(String passwd)
    throws NoSuchAlgorithmException,UnsupportedEncodingException {
        //声明加密后口令数组变量
        byte[] pwd = null;
        //随机数生成器   
        SecureRandom random = new SecureRandom();
        //声明盐数组变量   12
        byte[] salt = new byte[SALT_LENGTH];
        //将随机数放入盐变量中   
        random.nextBytes(salt);

        //声明消息摘要对象   
        MessageDigest md = null;
        //创建消息摘要   
        md = MessageDigest.getInstance("MD5");
        //将盐数据传入消息摘要对象   
        md.update(salt);
        //将口令的数据传给消息摘要对象   
        md.update(passwd.getBytes());
        //获得消息摘要的字节数组   
        byte[] digest = md.digest();

        //因为要在口令的字节数组中存放盐，所以加上盐的字节长度   
        pwd = new byte[digest.length + SALT_LENGTH];
        //将盐的字节拷贝到生成的加密口令字节数组的前12个字节，以便在验证口令时取出盐   
        System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
        //将消息摘要拷贝到加密口令字节数组从第13个字节开始的字节   
        System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);

        //将字节数组格式加密后的口令转化为16进制字符串格式的口令   
        return Des.parseByte2HexStr(pwd);

       
    }

    /**
     *
     * @param passwd   明文
     * @param dbPasswd 数据库密文
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean validPassword(String passwd,String dbPasswd)
        throws NoSuchAlgorithmException,UnsupportedEncodingException{
        byte[] pwdInDb = Des.parseHexStrByte2(dbPasswd);
        //声明盐变量
        byte[] salt = new byte[SALT_LENGTH];
        //将盐从数据库中保存的口令字节数组中提取出来
        System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);

        //创建消息摘要对象
        MessageDigest md = MessageDigest.getInstance("MD5");
        //将盐数据传入消息摘要对象
        md.update(salt);

        //将口令的数据传给消息摘要对象
        md.update(passwd.getBytes("UTF-8"));
        //生成输入口令的消息摘要
        byte[] digest = md.digest();
        //声明一个保存数据库中口令消息摘要的变量
        byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
        //取得数据库中口令的消息摘要
        System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
        //比较根据输入口令生成的消息摘要和数据库中消息摘要是否相同
        if (Arrays.equals(digest, digestInDb)) {
            //口令正确返回口令匹配消息
            return true;
        } else {
            //口令不正确返回口令不匹配消息
            return false;
        }


    }


}
