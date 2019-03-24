package com.ptteng.JAVARMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
//1.写一个接口类继承Remote接口,标识所包含的方法可以从非本地虚拟机上调用的接口，Remote接口本身不包含任何方法
        String sayHello(String name)throws RemoteException;
        //由于远程方法调用的本质依然是网络通信，只不过隐藏了底层实现，网络通信是经常会出现异常的，
    // 所以接口的所有方法都必须抛出RemoteException以说明该方法是有风险的
}
