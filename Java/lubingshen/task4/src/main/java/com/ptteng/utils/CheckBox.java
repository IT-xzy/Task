package com.ptteng.utils;

import com.ptteng.exception.StudentException;
import com.ptteng.utils.annotation.StringVerify;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CheckBox {
    public static final boolean INSERT = true;
    public static final boolean UPDATE = false;
    public static final boolean LOGIN = true;
    public static final boolean REGISTER = true;

    public static void check(Object model, boolean operation) throws Exception {
        if (operation)
            insertCheck(model);
        else
            updateCheck(model);
    }

    private static void insertCheck(Object model) throws Exception {
        Field[] fields = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (Field field : fields) { // 遍历所有属性
            if (field.isAnnotationPresent(StringVerify.class)) {
                StringVerify sv = field.getAnnotation(StringVerify.class);
                String name = field.getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便使用get，set方法
                String type = field.getGenericType().toString(); // 获取属性的类型
                if (!type.equals("class java.lang.String"))  // 如果type是类类型，则这里应该是"class "+ 类名
                    throw new RuntimeException("程序严重错误，非法注解！");    //不为字符串就说明注解标注的参数类型错误
                Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model); // 调用getter方法获取属性值
                if (value == null || value.equals(""))
                    throw new StudentException(sv.aliasName() + "的值不允许为空值！");
                if (value.length() < sv.minLength() || value.length() > sv.maxLength())
                    throw new StudentException(sv.aliasName() + "的长度太短或者太长！");
            }
        }
    }

    private static void updateCheck(Object model) throws Exception {
        Field[] fields = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (Field field : fields) { // 遍历所有属性
            if (field.isAnnotationPresent(StringVerify.class)) {
                StringVerify sv = field.getAnnotation(StringVerify.class);
                String name = field.getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便使用get，set方法
                String type = field.getGenericType().toString(); // 获取属性的类型
                if (!type.equals("class java.lang.String"))  // 如果type是类类型，则这里应该是"class "+ 类名
                    throw new RuntimeException("程序严重错误，非法注解！");      //不为字符串就说明注解标注的参数类型错误
                Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model); // 调用getter方法获取属性值
                if (value == null || value.equals(""))
                    continue;
                if (value.length() < sv.minLength() || value.length() > sv.maxLength())
                    throw new StudentException(sv.aliasName() + "的长度太短或者太长！");
            }
        }
    }
}
