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
    public static String random(int ix){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<ix;i++)
        {
            Integer a ;
            a =random.nextInt(10);
            sb.append(a);
        }
        
        return sb.toString();
    }
    
}
