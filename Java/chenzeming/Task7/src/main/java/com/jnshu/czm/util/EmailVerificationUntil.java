package com.jnshu.czm.util;

public class EmailVerificationUntil {

    public static boolean emailVerification(String email){

        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(EMAIL_REGEX)){
            return true;
        }else {
            return false;
        }

    }
}
