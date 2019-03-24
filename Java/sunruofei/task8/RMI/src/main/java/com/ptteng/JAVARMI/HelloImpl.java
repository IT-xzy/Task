package com.ptteng.JAVARMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @ClassName HelloImpl
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/19  18:27
 * @Version 1.0
 **/
public class HelloImpl  extends UnicastRemoteObject implements Hello {
    //2.创建远程方法接口实现类,需要继承UnicastRemoteObject,实现Hello

    private static final long serialVersionUID = 1733623682671895257L;
    //Java 的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
    // 在进行反序列化时，JVM 会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
    // 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。

    //这里需要显式的调用父类的构造方法,因为要抛出RemoteException
    public HelloImpl() throws RemoteException{
        super();
    }


    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello"+name;
    }
}
