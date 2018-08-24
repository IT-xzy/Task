package com.fgh.task2.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Pattern实例订制了一个所用语法与PERL的类似的正则表达式经编译后的模式，
// 然后一个Matcher实例在这个给定的Pattern实例的模式控制下进行字符串的匹配工作。
public class ChinaPhone {
    public static boolean isPhoneLegal(String str){
        String regExp="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        //Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
        Pattern p = Pattern.compile(regExp);
        //快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.返回一个Matcher对象
        Matcher m = p.matcher(str);
        //matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        return m.matches();
    }
}
