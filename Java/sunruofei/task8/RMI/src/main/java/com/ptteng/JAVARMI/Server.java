package com.ptteng.JAVARMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @ClassName Server
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  19:50
 * @Version 1.0
 **/
public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        // 创建一个远程对象，同时也会创建stub对象、skeleton对象
        Hello hello = new HelloImpl();
        //启动注册服务. 创建并导出接受指定 port 请求的本地主机上的 Registry 实例。
        LocateRegistry.createRegistry(2004);
        //注册对象，把对象与服务名绑定
        Naming.bind("//127.0.0.1:2004/wo", hello);
        System.out.println("服务在运行");
    }
}
