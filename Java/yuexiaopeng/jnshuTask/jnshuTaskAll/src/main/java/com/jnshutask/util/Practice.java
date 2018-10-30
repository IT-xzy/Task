package com.jnshutask.util;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.util.Properties;

public class Practice extends DataSwap
{
    static{
        System.out.println("子类的静态代码块");
    }
    {
        System.out.println("子类的代码块");
    }
    Practice(String one){
        super(one);
        System.out.println("子类对象的一参构造函数");
    }
    Practice(String two,String one){
        this(one);
        System.out.println("子类对象的二参构造函数");
    }
    public static void main(String[]args) throws Exception{
        new Practice("one","two");
        Properties p=new Properties();
        p.setProperty("one","wukong");
        p.setProperty("two","bajie");
        p.store(new FileOutputStream("test.properties"),"test pro");
        p.store(new FileOutputStream("test.ini"),"test pro");
        p.store(new FileOutputStream("test.xml"),"test pro");
        p.store(new FileOutputStream("test.jpg"),"test pro");
        System.out.println(p);
    }
}
