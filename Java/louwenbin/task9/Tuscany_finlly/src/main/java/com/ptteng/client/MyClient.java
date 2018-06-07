package com.ptteng.client;

import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;


@Component
public class MyClient {
    private static Logger logger = Logger.getLogger(MyClient.class);

    private UserService userService;

    public UserService getUserService() throws RemoteException, NotBoundException, MalformedURLException {
        Random random=new Random();
        int i =  random.nextInt(2)+1;
        try {
            if (i == 1) {
                logger.info("启动server1");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8998/TuscanyService");
            } else {
                logger.info("启动server2");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8999/TuscanyService");
            }
        } catch (Exception e1) {
            if (i != 1) {
                logger.info("server2挂了,启动server1");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8998/TuscanyService");
            } else {
                logger.info("server1挂了,启动server2");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:8999/TuscanyService");
            }
        }
        return userService;
    }


}
