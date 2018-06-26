package com.alibaba.util;

public class LoginBiz {
    static  boolean isValid(String user,String pass){
        if(user.equals("777")&&pass.equals("666")){
            return true;
        }else{
            return false;
        }
    }
}
