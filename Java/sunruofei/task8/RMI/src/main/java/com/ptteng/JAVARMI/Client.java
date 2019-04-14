package com.ptteng.JAVARMI;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @ClassName Client
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  19:59
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //查找对象，返回与指定名称相同的对象。
        Hello hello = (Hello) Naming.lookup("//127.0.0.1:2004/wo");
        System.out.println( hello.sayHello("sun"));


    }

}
