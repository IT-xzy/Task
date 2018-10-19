//
//
package com.utils;

public class EMailVerifiUtil {
    public static boolean emailVerification(String email){
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(EMAIL_REGEX)){
            return true;
        }else {
            return false;
        }
    }
}











//package com.utils;
//import java.util.regex.Pattern;
//public class EMailVerifiUtil {
//    public static boolean isEmail(String email) {
//        String REGEX_EMAIL ="^([a-z0-9A-Z]+[-|/.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?/.)+[a-zA-Z]{2,}$";
//        return Pattern.matches(REGEX_EMAIL, email);
//    }
//}
