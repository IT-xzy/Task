package com.javase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args)throws Exception {
//        无参构造实例对象
        Student instanceA=Student.class.newInstance();
        Constructor<Student> constructorA = Student.class.getConstructor();
        Student instanceA2=constructorA.newInstance();
//有参构造实例对象
        Constructor<Student> constructorB = Student.class.getConstructor(String.class,int.class);
        Student instanceB = constructorB.newInstance("刘", 25);
        System.out.println(instanceB.getName()+"\n"+instanceB.getAge());

//访问属性值
        Student s=new Student();
        Class<Student> studentClass=Student.class;
//        可获取各种访问控制符的属性
        Field nameField = studentClass.getDeclaredField("name");
//        设置通过反射访问私有属性是取消访问检查
        nameField.setAccessible(true);
        nameField.set(s,"李");
        System.out.println(s.getName());


//        使用反射动态执行方法
//        Class clazz=Student.class;
//        Object obj=clazz.newInstance();
        Method method = studentClass.getMethod("setName", String.class);
        method.invoke(s, "赵");
        System.out.println(s.getName());

        Method method1 = studentClass.getMethod("getName", new Class[]{});
        Object obj1 = method1.invoke(s, new Object[]{});
        System.out.println("返回值为："+obj1);
    }

}
