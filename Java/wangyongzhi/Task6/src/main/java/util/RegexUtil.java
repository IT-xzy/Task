package util;

import java.util.Map;

/**
 *@Description: 使用正则方式验证用户名和密码的工具类
 *@author:
 */
public class RegexUtil {

    /**
     *@Description: 禁止使用无参构造创建类对象调用方法
     *@param:
     **/
    private RegexUtil(){
        throw new UnsupportedOperationException("u can't instantiate me..");
    }

    /**
     *@Description: 同时验证用户名、密码、重复密码：1、是否为空；2、是否满足正则要求；3、两次密码是否相同
     * @param: username password repassword msg
     * @return: true：全部满足；false：带着不匹配的信息返回；
     */
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

    /**
     *@Description: 验证两次密码是否符合格式且是否相同
     * @param: password repassword
     * @return: msg.isEmpty() Boolean
     */
    public static Boolean validate(String password, String repassword, Map<String, String> msg) {
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
}
