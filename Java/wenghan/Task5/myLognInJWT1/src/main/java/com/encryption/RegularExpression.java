package com.encryption;

//正则表达式工具类
public class RegularExpression {
    //用户名正则
    public static boolean checkUsername(String username){
        if (username == null){
            return  false;
        }
        return  username.matches("[a-zA-Z]{1,20}[0-9]{1,20}");
    }
    //密码正则
    public static boolean checkPwd(String pwd){
        if (pwd == null){
            return  false;
        }
        return  pwd.matches("^[0-9]{3,20}");
    }
}
