package com.test.client;

import com.ssm.service.UserService;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TuscanyTest {
    @Test
    public void test() throws RemoteException, NotBoundException, MalformedURLException {
        UserService userService = (UserService) Naming.lookup("rmi://127.0.0.1:1111/UserService");
        System.out.println(userService.getById(1));
    }
}
