package com.ssm.utils;

import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIUtils {

    private static final Logger logger = LoggerFactory.getLogger(RMIUtils.class);

    public static UserService selectService() throws RemoteException, NotBoundException, MalformedURLException {
        UserService userService = null;
        int randomNum = (int) (Math.random() * 10);
        try {
            if (randomNum % 2 != 0) {
                logger.info("奇数try调用 NO.1 service");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:1111/UserService");
            } else {
                logger.info("偶数try调用 NO.2 service");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:2222/UserService");
            }
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            logger.error("catch exception:"+e);
            if (randomNum % 2 == 0) {
                logger.info("偶数，调用catch内 NO.1");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:1111/UserService");
            } else {
                logger.info("奇数，调用catch内 NO.2");
                userService = (UserService) Naming.lookup("rmi://127.0.0.1:2222/UserService");
            }
        }
        return userService;
    }
}
