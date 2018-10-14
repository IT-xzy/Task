package util;

import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class EncryptionUtil {
    /***
     *  利用Apache的工具类实现SHA-256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encodeStr = Hex.encodeHexString(hash);
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     *  利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update((str.getBytes("UTF-8")));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  encodeStr;
    }

    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0;i < bytes.length; i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    /**
     * 加盐方法
     * @param
     * @return
     */
    public static String getNextSalt() {
        String str = "";
        try {
            Random RANDOM = new SecureRandom();
            byte[] salt = new byte[16];
            RANDOM.nextBytes(salt);
            //把salt字节数组按UTF-8的格式转换成字符串
            str = new String(salt, "UTF-8");
            //把字符串转换成数字和字母类的字符串
            str = new BASE64Encoder().encode(salt);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
