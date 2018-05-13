/*package com.fml.rmi;

import java.lang.reflect.Method;

public class RunMain {
    //构造方法
    public RunMain() throws Exception {
        Class clazz = Class.forName("com.fml.rmi.Run");
        Object obj = clazz.newInstance();
        Method mainMethod = clazz.getMethod("main", String[].class);
        //public static void main(String[] args)
        mainMethod.invoke(obj, (Object) new String[]{"a", "b", "c"}); //String[]随便赋值的
    }
}*/
