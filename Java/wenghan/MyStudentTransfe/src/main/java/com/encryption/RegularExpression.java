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
    //手机正则
    public static boolean checkPhone(String phome){
        if(phome==null){
            return false;
        }
        return phome.matches("[1][3,4,5,7,8][0-9]{9}");
    }

    public static boolean checkMail(String mail){
        if(mail==null){
            return false;
        }
        return mail.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
    }
}
