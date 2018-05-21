package com.util;

import com.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RMI.class);

    public static StudentService getService()  {

        StudentService studentService = null;

        int i = (int) (Math.random() * 2);
        if (i == 0) {
            try {
                studentService = (StudentService) Naming.lookup("//127.0.0.1:1199/TuscanyService");
                logger.info("service1199 action");
            } catch (Exception e) {
                try {
                    studentService = (StudentService) Naming.lookup("//127.0.0.1:1198/TuscanyService");
                } catch (NotBoundException e1) {
                    e1.printStackTrace();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                logger.info("service1199 bad to service1198 action");
            }

        } else {
            try {
                studentService = (StudentService) Naming.lookup("//127.0.0.1:1198/TuscanyService");
                logger.info("service1198 action");
            } catch (Exception e) {
                try {
                    studentService = (StudentService) Naming.lookup("//127.0.0.1:1199/TuscanyService");
                } catch (NotBoundException e1) {
                    e1.printStackTrace();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                logger.info("service1198 bad to service1199 action");
            }
        }
        return studentService;
    }
}
