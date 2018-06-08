package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {
    public static  List<String> passwordsalt (String user_password){
            Random random = new Random();
            StringBuilder stringBuilder = new StringBuilder(16);
            stringBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
            int length = stringBuilder.length();
            if(length<16){
                for(int i=0; i<16-length; i++){
                    stringBuilder.append("0");
                }
            }
        String salt = stringBuilder.toString();
        user_password = DigestUtils.md5Hex(user_password+salt);
        char[] chars = new char[48];
                for(int i=0; i<48; i+=3){
            chars[i]=user_password.charAt(i/3 *2);
            char c = salt.charAt(i/3);
            chars[i+1]=c;
            chars[i+2]=user_password.charAt(i/ 3*2 +1);
            }
            List<String> list = new ArrayList<String>();
            list.add(salt);
            list.add(new String(chars));
            return  list;
    }
    public static  String passwordtest (String user_password,String salt){
        user_password=DigestUtils.md5Hex(user_password+salt);
        char[] chars = new char[48];
        for(int i=0; i<48; i+=3) {
            chars[i] = user_password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            chars[i + 1] = c;
            chars[i + 2] = user_password.charAt(i / 3 * 2 + 1);
        }
        return new String(chars);
    }
}
