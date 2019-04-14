package com.ptteng.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestReflection
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/14  18:55
 * @Version 1.0
 **/
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "com.ptteng.reflection.T";
        //根据名字把这个类Load进内存
        Class c = Class.forName(str);
        //生成Test类的对象
        Object o = c.newInstance();
        //拿到Test对象的方法,c.getMethods()返回值是一个数组
        Method[] methods = c.getMethods();
        //遍历methods
        for (Method m : methods) {
//            //拿到方法的名字
            System.out.println(m.getName());
//            调用mm方法
            if (m.getName().equals("mm")) {
                m.invoke(o);
            }
        }
    }

}
