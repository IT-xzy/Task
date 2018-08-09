package utils;

import java.util.Map;

public class RegexUtil {

    //无参构造方便创建类对象调用方法
    private RegexUtil(){
        throw new UnsupportedOperationException("u can't instantiate me..");
    }

    public static Boolean validate(String username,String password,
                                   String repassword, Map<String, String> msg) {
        //用户名：必须输入，且用户名为3-8位的字母和数字组成
        if ("".equals(username)) {
            msg.put("username", "用户名不能为空");
        } else if (!username.matches("\\w{3,8}")) {
            msg.put("username", "用户名为3-8位的字母和数字组成");
        }
        //密码：必须输入，且用密码为3-8位的数字组成
        if ("".equals(password)) {
            msg.put("password", "密码不能为空");
        } else if (!password.matches("\\d{3,8}")) {
            msg.put("password", "密码为3-8位的数字组成");
        }

        if ("".equals(repassword)) {
            msg.put("repassword", "密码不能为空");
        }
        else if (!repassword.equals(password)){
            msg.put("repassword", "两次输入密码不一致，请重新输入");
        }
        return msg.isEmpty();

    }

    public static boolean validate(String password, String repassword, Map<String, String> msg) {
        //密码：必须输入，且用密码为3-8位的数字组成
        if ("".equals(password)) {
            msg.put("password", "密码不能为空");
        } else if (!password.matches("\\d{3,8}")) {
            msg.put("newpassword", "密码为3-8位的数字组成");
        }

        if ("".equals(repassword)) {
            msg.put("repassword", "密码不能为空");
        }
        else if (!repassword.equals(password)){
            msg.put("repassword", "两次输入密码不一致，请重新输入");
        }
        return msg.isEmpty();
    }

//    //简单验证模块
//    public boolean validate() {
//        //用户名：必须输入，且用户名为3-8位的字母和数字组成
//        if ("".equals(username)) {
//            msg.put("username", "用户名不能为空");
//        } else if (!username.matches("\\w{3,8}")) {
//            msg.put("username", "用户名为3-8位的字母和数字组成");
//        }
//        //密码：必须输入，且用密码为3-8位的数字组成
//        if ("".equals(password)) {
//            msg.put("password", "密码不能为空");
//        } else if (!password.matches("\\d{3,8}")) {
//            msg.put("password", "密码为3-8位的数字组成");
//        }
//
//        if ("".equals(repassword)) {
//            msg.put("repassword", "密码不能为空");
//        }
//        else if (!repassword.equals(password)){
//            msg.put("repassword", "两次输入密码不一致，请重新输入");
//        }
//        return msg.isEmpty();
//
//    }
}
