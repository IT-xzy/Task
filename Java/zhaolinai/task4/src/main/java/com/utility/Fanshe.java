package com.utility;

/**
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 */


public class Fanshe {

    public static void main(String[] args) {
        //第一种方式获取Class对象
        Student student = new Student();             //Student这个类也是一个实例对象
        Class stuClass1 = student.getClass();       //已知该类的对象，通过getClass方法获取Class对象
        System.out.println(stuClass1.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;        //任何一个类都有一个隐含的静态成员变量
        System.out.println(stuClass1 == stuClass2);//一个类只可能是Class类的一个对象

        /*stuClass1/stuClass2表示了Student类的类类型（class type）
         * 类也是对象，是class类的实例对象
         * 这个对象我们称为该类的类类型
         * */



        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("com.utility.Student");
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//注意：在运行期间，一个类，只有一个Class对象产生。

// 第一种对象都有了还要反射干什么。
// 第二种需要导入类的包，依赖太强，不导包就抛编译错误。
// 常用第三种，一个字符串可以传入也可写在配置文件中等多种方法。