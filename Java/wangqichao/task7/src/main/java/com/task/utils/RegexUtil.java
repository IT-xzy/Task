package com.task.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配工具类
 */
public class RegexUtil {
    //无参构造方便创建类对象调用方法
    private RegexUtil(){
        throw new UnsupportedOperationException("u can't instantiate me...");
    }
    /**
     * 匹配用户名是否符合正则
     * @param username
     * @return
     */
    //设置为静态方法，可以使用类来调用此方法
    public static Boolean usernameRegex(String username){
        //匹配规则为第一个必须为字母，其余的可以为字母，数字下划线，4-16位
        String regex="^[a-zA-Z]{1}[a-zA-z0-9_]{3,15}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(username);
        boolean flag=match.matches();
        return flag;
    }
    /**
     * 匹配密码是否符合正则
     * @param password
     * @return
     */
    public static Boolean passwordRegex(String password){
        //匹配规则为可以为字母数字的4-16位组合
        String regex="^[a-zA-Z0-9]{4,16}";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(password);
        boolean flag1=match.matches();
        return flag1;
    }

    /**
     * 真实姓名正则匹配
     * @param name
     * @return
     */
    public static Boolean nameRegex(String name){
        String regex="^([\\u4e00-\\u9fa5]{1}[\\u4e00-\\u9fa5\\·]{0,8}[\\u4e00-\\u9fa5]{1})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(name);
        boolean flag2=match.matches();
        return flag2;
    }

    /**
     * 手机号码正则匹配
     * @param telephone
     * @return
     */
    public static Boolean telephoneRegex(String telephone){
        String regex="^(((13|14|15|18|17)\\d{9}))$";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(telephone);
        boolean flag3=match.matches();
        return flag3;
    }

    public static Boolean emailRegex(String email){
        String regex="^(([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(email);
        boolean flag4=match.matches();
        return flag4;
    }


}
