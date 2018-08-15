package com.task.util;

import com.task.service.HelloService;
import com.task.service.StudentService;
import com.task.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class TuscanyServiceUtil {

    private HelloService helloService;
    private UserService userService;
    private StudentService studentService;

    private String IP1 = "//localhost";
    private String IP2 = "//localhost";
    private String PORT1 = ":8085";
    private String PORT2 = ":8086";
    private String Service1 = "/HelloService";

    private String Service2 = "/UserService";
    private String Service3 = "/StudentService";

    public HelloService getHelloService() throws RemoteException, NotBoundException, MalformedURLException {

        int a= (int) ((Math.random()*999999)%2);
        String source = null;
        if (a==0){
            source = IP1+PORT1+Service1;
        }
        else {
            source = IP2+PORT2+Service1;
        }

        return (HelloService) Naming.lookup(source);
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public UserService getUserService() throws RemoteException, NotBoundException, MalformedURLException {

        int a= (int) ((Math.random()*999999)%2);
        String source = null;
        if (a==0){
            source = IP1+PORT1+Service2;
        }
        else {
            source = IP2+PORT2+Service2;
        }

        return (UserService) Naming.lookup(source);

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public StudentService getStudentService() throws RemoteException, NotBoundException, MalformedURLException {

        int a= (int) ((Math.random()*999999)%2);
        String source = null;
        if (a==0){
            source = IP1+PORT1+Service3;
        }
        else {
            source = IP2+PORT2+Service3;
        }

        return (StudentService) Naming.lookup(source);
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
