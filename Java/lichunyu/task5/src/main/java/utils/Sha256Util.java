package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 利用Java原生的摘要实现SHA256加密
 */
public class Sha256Util {

    /**
     * 获得SHA256加密后密文
     */
    public static String createSha256(String strIn){
        MessageDigest messageDigest; //信息摘要
        String encodeStr =""; //加密后的字符串

        try {
            messageDigest = MessageDigest.getInstance("SHA-256"); //信息摘要实例采用SHA-256加密
            messageDigest.update(strIn.getBytes("UTF-8")); //将输入密文采用utf-8格式输出
            encodeStr = StrConvertUtil.byteArrToHexStr(messageDigest.digest()); //将密文转化成16进制字符串
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
}
