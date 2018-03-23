package com.ppteng;

import com.ptteng.bean.Student;
import com.ptteng.utils.CheckBox;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class Task2Test {
    @Test
    public void reflectTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Student student = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-4",
                "http://www.jnshu.com/daily/40038",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        System.out.println(CheckBox.check(student));
    }
}
