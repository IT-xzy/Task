package com.tool;

import com.service.Service;
import com.service.UserService;
import com.service.UserService1;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

public class MyService {

    private Logger logger=Logger.getLogger(MyService.class);

    public Service getService(){
        Random random=new Random();
        Service service=null;
        //产生0<=r<2的整数：0/1
        if(random.nextInt(2)==0){
            try {
                logger.info("连接服务器1");
                service=getUseService();
            }catch (Exception e){
                try {
                    logger.info("连接服务器1失败，重连服务器2");
                    service=getUseService1();
                } catch (RemoteException | MalformedURLException | NotBoundException e1) {
                    logger.info("连接服务器2失败");
                    e1.printStackTrace();
                }
            }
            return service;
        }

        try {
            logger.info("连接服务器2");
            service=getUseService1();
        }catch (Exception e){
            try {
                logger.info("连接服务器2失败,重接服务器1");
                service=getUseService();
            } catch (RemoteException | NotBoundException | MalformedURLException e1) {
                logger.info("连接服务器1失败");
                e1.printStackTrace();
            }
        }
        return service;
    }

    //服务器1
    private UserService getUseService() throws RemoteException, NotBoundException, MalformedURLException {
        UserService userService;
        userService=(UserService)Naming.lookup("rmi://127.0.0.1:1111/UserService");
        logger.info("serviceProxy");
        logger.info(userService);
        if(userService!=null) {
            return userService;
        }else {
            logger.info("空值错误");
            return null;
        }
    }

    //服务器2
    private UserService1 getUseService1() throws RemoteException, NotBoundException, MalformedURLException {
        UserService1 userService1;
        userService1=(UserService1)Naming.lookup("rmi://127.0.0.1:1112/UserService");
        if(userService1!=null) {
            logger.info("serviceProxy1");
            logger.info(userService1);
            return userService1;
        }else {
            logger.info("空值错误");
            return null;
        }
    }
}
