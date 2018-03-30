package lujing.security;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author lujing
 * Create_at 2018/1/4 10:56
 */
public class SaltGenerate {
    
    public static String getSalt() {
        
        Random ranGen = new SecureRandom();
        
        byte[] aesKey = new byte[10];
        
        ranGen.nextBytes(aesKey);
        
        return MessageDigestUtils.byteToString(aesKey);
        
    }
}
