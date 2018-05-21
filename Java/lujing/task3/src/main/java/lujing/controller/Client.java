package lujing.controller;

import lujing.service.ScaDemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



/**
 * @author lujing
 * Create_at 2018/1/29 20:42
 */
public class Client {
    public static void main(String[] args) {
        try {
            ScaDemo xx= (ScaDemo) Naming.lookup("//127.0.0.1:8088/ScaDemoService");
            System.out.println(xx.sayHi("nishuoxingbuxing"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
