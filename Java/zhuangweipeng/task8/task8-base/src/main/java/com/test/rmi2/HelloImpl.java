package com.test.rmi2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {
    protected HelloImpl() throws RemoteException{
        super();
    }
    private static final long serialVersionUID=4077329331699640331L;
    public String sayHello(String name) throws RemoteException{
        return "Hello"+name+"^_^";
    }
    public static void main(String args[]){
        try{
            IHello hello=new HelloImpl();
            java.rmi.Naming.rebind("rmi://localhost:1099/hello",hello);
            System.out.println("Read.....");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
