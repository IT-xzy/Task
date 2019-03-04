package com.jnshu.task8.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) {
        try {
            //创建一个远程对象
            Hello hello = new RmiImpl();
            // 在8080 监听
            LocateRegistry.createRegistry(8080);
            Naming.bind("rmi://localhost:8080/Hello" , hello);
            System.out.println(" 远程绑定对象成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
