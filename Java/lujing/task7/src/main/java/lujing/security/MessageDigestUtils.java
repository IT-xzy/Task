package lujing.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lujing
 * Create_at 2018/1/4 11:30
 */
public  class MessageDigestUtils {
    public static String SHA256(String message){
        MessageDigest md = null;
        String outStr = null;
        
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digest = new byte[0];
            try {
                digest = md.digest(message.getBytes("GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
    
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }
    
    public static String byteToString(byte[] digest) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            System.out.println(digest[i]);
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }
        
    
}
