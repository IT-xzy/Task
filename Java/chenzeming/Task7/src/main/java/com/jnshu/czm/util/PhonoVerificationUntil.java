package com.jnshu.czm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhonoVerificationUntil {

    public static boolean phoneVerification(String telephonme){

        Pattern pattern = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(telephonme);

        if (matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }
}
