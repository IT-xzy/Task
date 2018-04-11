package com.ptteng.utils;

import com.ptteng.pojo.exception.UnacceptableException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCheckUtil {
    /*非法字符检测，这里我就简单写一下，只允许大小写字母、数字和汉字。
     * 实际上，可以写一个更详细的检测机制，比如转义内容中的js标签，实现防止xss攻击等功能*/
    private static final Pattern NamePattern = Pattern.compile("[^a-zA-Z0-9\u4E00-\u9FA5]");
    private static final Pattern qqReg = Pattern.compile("^[1-9][0-9]{4,11}$");
    private static final Pattern cellphoneReg = Pattern.compile
            ("^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\\d{8})$");
    private static final Pattern mailReg = Pattern.compile
            ("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
    private static final Pattern imgReg = Pattern.compile(".*?\\.(jpg|png)$");

    public static void isImg(String str){
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("文件名不能为null");
        }
        //只允许后缀名为png或者.jpg的
        if (!imgReg.matcher(str).matches()) {
            throw new UnacceptableException("数据格式错误，类型：文件名，值：" + str);
        }
    }

    public static void isQQ(String str) {
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("QQ类型数据不能为null");
        }

        if (!qqReg.matcher(str).matches()) {
            throw new UnacceptableException("数据格式错误，类型：QQ，值：" + str);
        }
    }

    public static void isCellphone(String str) {
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("手机号类型数据不能为null");
        }

        if (!cellphoneReg.matcher(str).matches()) {
            throw new UnacceptableException("数据格式错误，类型：手机号，值：" + str);
        }
    }

    public static void isMail(String str) {
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("邮箱类型数据不能为null");
        }

        if (!mailReg.matcher(str).matches()) {
            throw new UnacceptableException("数据格式错误，类型：邮箱，值：" + str);
        }
    }

    //非法字符检测 名字合法性检测 只允许中文，数字，大小写字母
    public static void isName(String str) {
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("名字类型数据不能为null");
        }

        Matcher m = NamePattern.matcher(str);
        if (!m.replaceAll("").trim().equals(str)) {
            throw new UnacceptableException("数据格式错误，类型：姓名，值：" + str);
        }
    }

    public static void lenthCheck(String str, int min, int max) {
        //该方法不允许传入null
        if (str == null) {
            throw new UnacceptableException("限长类型的数据不能为null");
        }
        int size = str.length();
        if (size > max || size < min) {
            throw new UnacceptableException("数据长度非法， 值：" + str);
        }
    }

}
