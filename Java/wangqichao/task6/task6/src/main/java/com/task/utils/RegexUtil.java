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
}
