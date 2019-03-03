package com.jnshu.task8.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class RmiClient {

    public static void main(String[] args) {

        try {
            Hello hello = (Hello) Naming.lookup("rmi://localhost:8080/Hello");

            System.out.println(hello.helloWorld());

            Map<String ,Object > map = new HashMap<String ,Object>(16);
            map.put("name","test");
            map.put("age","18");

            System.out.println(hello.getPersonaInfo(map));



        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
