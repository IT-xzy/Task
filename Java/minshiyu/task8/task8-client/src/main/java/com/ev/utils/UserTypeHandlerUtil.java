package com.ev.utils;

import com.ev.exception.CustomException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserTypeHandlerUtil {

    public String typeHandler(String string) throws CustomException {

        String emailPattern="^[\\w.\\-]+@(?:[a-z0-9]+(?:-[a-z0-9]+)*\\.)+[a-z]{2,3}$";
        String phoneNumberPattern="^1[3|4|5|8]\\d{9}$";

        if(Pattern.matches(emailPattern, string )){
            return "email";
        } else if(Pattern.matches(phoneNumberPattern, string)){
            return "phoneNumber";
        } else {
            return "username";

        }
    }

}
