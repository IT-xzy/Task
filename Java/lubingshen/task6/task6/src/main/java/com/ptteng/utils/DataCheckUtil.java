package com.ptteng.utils;

import com.ptteng.pojo.exception.StudentException;
import com.ptteng.utils.annotation.StringVerify;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCheckUtil {
    public static final boolean INSERT = true;
    public static final boolean UPDATE = false;
    public static final boolean LOGIN = true;
    public static final boolean REGISTER = true;
    private static final Pattern illegelCheckPattern = Pattern.compile("[^a-zA-Z0-9\u4E00-\u9FA5]");

    public static void check(Object model, boolean operation) throws Exception {
        if (operation)
            insertCheck(model);
        else
            updateCheck(model);
    }

    public static boolean isNumber(String str) {
        //该方法允许传入null并返回true
        if (str == null) {
            return true;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }

    //检测是否含有非法字符，只允许大小写字母、数字和汉字
    public static boolean isNotIllegal(String str) {

        //该方法允许传入null并返回true
        if (str == null) {
            return true;
        }

        Matcher m = illegelCheckPattern.matcher(str);
        return m.replaceAll("").trim().equals(str);
    }

    private static void insertCheck(Object model) throws Exception {
        // 获取实体类的所有属性，返回Field数组
        Field[] fields = model.getClass().getDeclaredFields();
        // 遍历所有属性
        for (Field field : fields) {
            if (field.isAnnotationPresent(StringVerify.class)) {
                StringVerify sv = field.getAnnotation(StringVerify.class);
                // 获取属性的名字
                String name = field.getName();
                // 将属性的首字符大写，方便使用get，set方法
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                // 获取属性的类型
                String type = field.getGenericType().toString();
                // 如果type是类类型，则这里应该是"class "+ 类名
                if (!type.equals("class java.lang.String")) {
                    //不为字符串就说明注解标注的参数类型错误
                    throw new RuntimeException("程序严重错误，非法注解");
                }
                Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model); // 调用getter方法获取属性值

                //插入、注册的时候，严禁传入null或者空字符串
                if (value == null || value.equals("")) {
                    throw new StudentException(sv.aliasName() + "的值不允许为空值");
                }

                if (value.length() < sv.minLength()) {
                    throw new StudentException(sv.aliasName() + "的长度太短");
                }

                if (value.length() > sv.maxLength()) {
                    throw new StudentException(sv.aliasName() + "的长度太长");
                }

                if (sv.isNumber() && !isNumber(value)) {
                    throw new StudentException(sv.aliasName() + "必须为数字");
                }

                if (sv.isNotIllegal() && !isNotIllegal(value)) {
                    throw new StudentException(sv.aliasName() + "含有非法内容");
                }
            }
        }
    }

    private static void updateCheck(Object model) throws Exception {
        // 获取实体类的所有属性，返回Field数组
        Field[] fields = model.getClass().getDeclaredFields();
        // 遍历所有属性
        for (Field field : fields) {
            if (field.isAnnotationPresent(StringVerify.class)) {
                StringVerify sv = field.getAnnotation(StringVerify.class);
                // 获取属性的名字
                String name = field.getName();
                // 将属性的首字符大写，方便使用get，set方法
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                // 获取属性的类型
                String type = field.getGenericType().toString();
                // 如果type是类类型，则这里应该是"class "+ 类名
                if (!type.equals("class java.lang.String")) {
                    //不为字符串就说明注解标注的参数类型错误
                    throw new RuntimeException("程序严重错误，非法注解");
                }
                Method m = model.getClass().getMethod("get" + name);

                // 调用getter方法获取属性值
                String value = (String) m.invoke(model);

                //更新的时候允许前端传入空字符串或者null，采取动态sql更新
                if (value == null || value.equals("")) {
                    continue;
                }

                if (value.length() < sv.minLength()) {
                    throw new StudentException(sv.aliasName() + "的长度太短");
                }

                if (value.length() > sv.maxLength()) {
                    throw new StudentException(sv.aliasName() + "的长度太长");
                }

                if (sv.isNumber() && !isNumber(value)) {
                    throw new StudentException(sv.aliasName() + "必须为数字");
                }

                if (sv.isNotIllegal() && !isNotIllegal(value)) {
                    throw new StudentException(sv.aliasName() + "含有非法内容");
                }
            }
        }
    }
}
